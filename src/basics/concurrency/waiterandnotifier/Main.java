package basics.concurrency.waiterandnotifier;

public class Main {
    public static void main(String[] a) throws InterruptedException {
        Object lock = new Object();
        Thread thread1 = new Thread(new Waiter(lock));
        Thread thread2 = new Thread(new Waiter(lock));
        Thread notifier = new Thread(new Notifier(lock));
        thread1.start();
        Thread.sleep(500);//invoke sleep(...) to ensure thread1 runs first
        thread2.start();
        notifier.start();
    }

}
