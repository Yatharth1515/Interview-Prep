package ReentrantLocks;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;

    public void producer(ReentrantLock lock) throws InterruptedException {
        try {
            System.out.println(" waiting for lock :- " + Thread.currentThread().getName());
            lock.lock();
            System.out.println(" lock acquired by :- " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("Lock released :- " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

}
