 package org.example;

 import java.lang.reflect.Array;
 import java.util.*;
 import java.util.concurrent.ConcurrentHashMap;

 public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] arr = {11, 3, 17, 5, 10};
        String[] strings = {"a", "b", "z", "y"};

//        Arrays.sort(arr, new Comparator<Integer> () {
//            public int compare(Integer v1, Integer v2){
//                return v2 - v1;
//            }
//        });
//        Arrays.sort(arr, (o1, o2) -> o2-o1);
//
//        for (Integer i : arr) {
//            System.out.print(" " + i);
//        }

        Car car1 = new Car("Suv","petrol");
        Car car2 = new Car("Sedan","Diesel");
        Car car3 = new Car("HatchBack","Cng");
        Car car4 = new Car("CompactSUV","ev");
        Car car5 = new Car("CompactSUV","petrol");
        Car[] cars = new Car[]{car1,car2,car5,car4,car3};
        //Arrays.sort(cars, (Car o1, Car o2) -> o1.carType.compareTo(o2.carType));
        //Arrays.sort(cars, new CarComparator());
        Arrays.sort(cars);
        for (Car c: cars){
            System.out.print(c.carName + " " +c.carType + " -- ");
        }
        System.out.println( );
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(12,12);
        map.putIfAbsent(12,14);
        map.putIfAbsent(14,15);
        for (Integer m : map.values()){
            System.out.println(m);
        }
        for (Map.Entry<Integer,Integer> mpp : map.entrySet()){

            System.out.println(mpp.getKey() + mpp.getValue());
        }

    }

}