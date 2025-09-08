package Condition;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private Queue<Integer> sharedQueue;
    private int bufferSize;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public SharedResource(int bufferSize){
        this.sharedQueue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }
    public  void produce(int item) throws InterruptedException {
        try {
            lock.lock();
            while (sharedQueue.size() == bufferSize){
                System.out.println("Producer thread is waiting, sharedQueue is full");
                condition.await();
            }
            System.out.println("Thread available to insert ,inserting item :- " + item);
            sharedQueue.add(item);
            condition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
    public  int consume() throws InterruptedException {
        try {
            lock.lock();
            while (sharedQueue.isEmpty()){
                System.out.println("consumer thread is waiting, queue is empty");
                condition.await();
            }
            int consumedItem = sharedQueue.poll();
            System.out.println("consumed item :- " + consumedItem);
            condition.signalAll();
            return consumedItem;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
