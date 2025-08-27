package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
// Thread creation using runnable interface . its mostly preferred in industry since using interface other classes can be extended
        MyRunnable runnableObj = new MyRunnable();
        Thread t = new Thread(runnableObj);
        t.start();
        System.out.println(Thread.currentThread().getName());
// Thread using Thread class
        MyThread th = new MyThread();
        th.start();
        System.out.println(Thread.currentThread().getName());

    }
}