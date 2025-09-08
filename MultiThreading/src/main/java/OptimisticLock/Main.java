package OptimisticLock;

public class Main {
    public static void main(String[] args) {
        OptimisticResource op = new OptimisticResource();
        Thread t = new Thread(op::producer);
        Thread t1 = new Thread(() -> {
            try {
                op.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        t1.start();

        System.out.println("value :-"+ op.a);
    }
}
