package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    private Queue<Integer> sharedQueue;
    private int bufferSize;
    public SharedResource(int bufferSize){
        this.sharedQueue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }
    public synchronized void produce(int item) throws InterruptedException {
        while (sharedQueue.size() == bufferSize){
            System.out.println("Producer thread is waiting, sharedQueue is full");
           wait();
        }
        System.out.println("Thread available to insert:- " + item);
        sharedQueue.add(item);
        notifyAll();
    }
    public synchronized int consume() throws InterruptedException {

        while (sharedQueue.isEmpty()){
            System.out.println("consumer thread is waiting, queue is empty");
            wait();
        }
        int consumedItem = sharedQueue.poll();
        System.out.println("consumed item :- " + consumedItem);
        notifyAll();
        return consumedItem;
    }
}
