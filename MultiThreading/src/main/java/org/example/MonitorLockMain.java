package org.example;

public class MonitorLockMain {
    public static void main(String[] args) {

        MonitorLock obj = new MonitorLock();

        MonitorLockRunnable runnable = new MonitorLockRunnable(obj);

        Thread t = new Thread(runnable);
        Thread t2 = new Thread(obj::task2);
        Thread t3 = new Thread(obj::task3);

        t.start();
        t2.start();
        t3.start();
        /* output
            task2 but before sync synchronized
            task 3
            inside task1
            task 1 completed
            task 2 after synchronized
         */
    }
}
