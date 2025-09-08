package OptimisticLock;

import java.util.concurrent.locks.StampedLock;

public class OptimisticResource {
    int a = 10;
StampedLock lock = new StampedLock();
    public void producer(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(3000);
            if(lock.validate(stamp)){
                System.out.println("raed successfully");
            }else {
                System.out.println("rollback to original");
                a = 10;
            }
        }catch (Exception e){

        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(5000);
        long stamp = lock.writeLock();
        System.out.println("writelock acquired by " + Thread.currentThread().getName());
        try {
            System.out.println("performing changes");
            a  = 9;
        }finally {
            lock.unlockWrite(stamp);
            System.out.println("write lock released by " + Thread.currentThread().getName());
        }
    }
}
