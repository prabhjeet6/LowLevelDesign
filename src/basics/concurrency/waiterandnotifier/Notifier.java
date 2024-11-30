package basics.concurrency.waiterandnotifier;

public class Notifier implements Runnable {
    private final Object lock;//monitor

    public Notifier(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
