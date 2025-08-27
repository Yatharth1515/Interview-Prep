package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world to Tree DS!");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //inOT(root);
        //levelOT(root);
        int ans = maxDepth(root);
        System.out.println(ans);
    }
    public static void inOT(TreeNode root){
        if (root == null)
            return;

        inOT(root.left);
        System.out.println(root.val);
        inOT(root.right);
    }
    public static void levelOT(TreeNode root){
        if (root == null)
            return;

        Queue<TreeNode> qe = new LinkedList<>();
        qe.add(root);

        while (!qe.isEmpty()){
            int size = qe.size();

            for (int i = 0; i < size; i++) {
                TreeNode temp = qe.poll();
                System.out.println(temp.val);
                if (temp.left != null){
                    qe.add(temp.left);
                }
                if (temp.right != null){
                    qe.add(root.right);
                }

            }
        }
    }
    public static int maxDepth(TreeNode node){
        if (node == null)return 0;
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        return 1+ Math.max(left,right);

    }

}