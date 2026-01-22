package OptimisticLock;

import java.util.*;
import java.util.concurrent.locks.StampedLock;

public class OptimisticResource {
    int a = 10;
StampedLock lock = new StampedLock();
    public void producer(){
        long stamp = lock.tryOptimisticRead();
        try{
            System.out.println("Taken optimistic lock");
            Thread.sleep(5000);
            if(lock.validate(stamp)){
                System.out.println("read successfully value of a :- "+ a);
            }else {
                a = 10;
                System.out.println("rollback to original value of a :- "+ a);

            }
        }catch (Exception e){

        }
    }

    public void consumer() throws InterruptedException {
        Thread.sleep(3000);
        long stamp = lock.writeLock();
        System.out.println("writelock acquired by " + Thread.currentThread().getName());
        try {
            a  = 9;
            System.out.println("performing changes ,value of a :- " + a);

        }finally {
            lock.unlockWrite(stamp);
            System.out.println("write lock released by " + Thread.currentThread().getName() + " value of a :- " + a);
        }
    }
}
