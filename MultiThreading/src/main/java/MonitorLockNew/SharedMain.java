package MonitorLockNew;

public class SharedMain {
    public static void main(String[] args) {

        SharedResource sharedResourceObj = new SharedResource();
        Thread producerThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                sharedResourceObj.addItem();
            }catch (Exception e){
                System.out.println("exception occurred"+e);
            }

        });

        Thread consumerThread = new Thread(sharedResourceObj::consumeItem);
        producerThread.start();
        consumerThread.start();
    }
}
