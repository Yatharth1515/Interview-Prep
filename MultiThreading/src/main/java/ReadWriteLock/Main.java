package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {

        ReadWriteLocksResource  locksResource = new ReadWriteLocksResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread t1 = new Thread(() -> {
            try {
                locksResource.producer(lock);
            } catch (Exception e) {
                System.out.println(" exception in T1");
            }
        });

        Thread t2 = new Thread(() -> {
            try {

                locksResource.producer(lock);
            } catch (Exception e) {
                System.out.println("exception in T2");
            }
        });
        ReadWriteLocksResource  locksResource2 = new ReadWriteLocksResource();
        Thread t3 = new Thread(() -> {

            locksResource2.consumer(lock);
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
