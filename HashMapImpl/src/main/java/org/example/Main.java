package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world to implementation of HashMap");


        MyHashMap<Integer, String> mpp = new MyHashMap<>(100);
        mpp.put(1, "YSB");
        mpp.put(2, "Its working fine");
        mpp.put(11, "abc");
        mpp.put(12, "def");
        mpp.put(1, " YSB is learning and enjoying the process");


//        Map<String, String> newMap = new HashMap<>(200);
//        newMap.put("YSB", "yes YSB is great");
//        newMap.put("Sanchit", "sanchit is learning HashMap impl");

//        System.out.println(newMap.get("YSB"));
//        System.out.println(newMap.get("Sanchit"));
        System.out.println(mpp.get(1));
        System.out.println(mpp.get(2));
        System.out.println(mpp.get(3));
        System.out.println(mpp.get(11));
        System.out.println(mpp.get(12));
        //System.out.println(mpp.get(null));
    }
}