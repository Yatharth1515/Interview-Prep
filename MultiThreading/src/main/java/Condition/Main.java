package Condition;

import Condition.SharedResource;

public class Main {
    public static void main(String[] args) {

        System.out.println("Producer consumer implementation");
       SharedResource sharedResource = new SharedResource(3);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t1 = new Thread(() -> {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < 6; i++) {
                try {
                    int consumedItem = sharedResource.consume();
//                    System.out.println("consumedItem from consumer thread " + consumedItem);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        t.start();
        t1.start();
    }
}
