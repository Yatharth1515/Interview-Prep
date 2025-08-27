package org.example;

public class MonitorLock {
    public synchronized void  task1() {
        try{
            System.out.println("inside task1");
            Thread.sleep(10000);
            System.out.println("task 1 completed :- "+ System.currentTimeMillis());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public void task2(){
        System.out.println("task2 but before sync synchronized");
        synchronized(this){
            System.out.println("task 2 after synchronized with time :- "+ System.currentTimeMillis());
        }
    }
    public void task3(){
        System.out.println("task 3");
    }
}
