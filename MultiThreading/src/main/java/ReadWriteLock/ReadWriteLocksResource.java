package ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLocksResource {

    public void producer(ReadWriteLock readWriteLock){

        try {
            System.out.println("waiting to acquire lock :- " + Thread.currentThread().getName());
            readWriteLock.readLock().lock();
            System.out.println("readLock acquired by :- " + Thread.currentThread().getName());
            Thread.sleep(2000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            readWriteLock.readLock().unlock();
            System.out.println("readLock released by :- " + Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock readWriteLock){
        try {
            readWriteLock.writeLock().lock();
            System.out.println("writeLock acquired by :- " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            readWriteLock.writeLock().unlock();
            System.out.println("writeLock released by :- " + Thread.currentThread().getName());
        }
    }
}
