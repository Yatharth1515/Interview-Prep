package ReentrantLocks;

import java.lang.annotation.Inherited;
import java.util.concurrent.locks.ReentrantLock;

public class LocksMain {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();

        Thread t = new Thread(()-> {
            try {
                sharedResource1.producer(lock);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                sharedResource2.producer(lock);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        t1.start();
    }
}
