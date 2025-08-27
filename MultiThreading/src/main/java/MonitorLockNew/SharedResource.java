package MonitorLockNew;

public class SharedResource {
    boolean isAvailable = false;
    public synchronized void  addItem(){
        isAvailable = true;
        System.out.println("producer thread calling notify");
        notifyAll();
    }
    public synchronized void consumeItem(){
        System.out.println("Consumer Thread inside consumeItem method");
        if (!isAvailable){
            try {
                System.out.println("consumer thread is waiting");
                wait();//releases all the monitor locks
            }catch (Exception e){
                System.out.println(e);
            }
        }
        isAvailable = false;
        System.out.println("consumer Thread gets the lock");
    }
}
