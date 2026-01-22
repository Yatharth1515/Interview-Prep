package ProducerConsumer;

public class PCMain {
    public static void main(String[] args) throws InterruptedException {
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
            for (int i = 0; i < 6; i++) {
                try {
                    int consumedItem = sharedResource.consume();
                   // System.out.println("consumedItem from consumer thread " + consumedItem);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        t.start();
        t1.start();

        try {
            System.out.println("main thread is waiting for other threads to complete");
            t.join();
            t1.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(" T1 and T2  threads finished ");

        Thread newT = new Thread(()->{
            try {
                sharedResource.produce(1000);
                Thread.sleep(1000);
                sharedResource.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        newT.start();
        System.out.println("main thread waiting for newT");

        newT.join();
        System.out.println("all threads finished");

    }

}
