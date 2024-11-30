package basics.concurrency.waiterandnotifier;

public class Waiter implements Runnable {
    private final Object lock;//monitor

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Hi, I am " + Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executed " + Thread.currentThread().getName());
        }
    }
}
