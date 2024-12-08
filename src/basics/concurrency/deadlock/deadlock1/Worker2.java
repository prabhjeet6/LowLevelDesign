package basics.concurrency.deadlock.deadlock1;

public class Worker2 implements Runnable {
    private final Object lock1, lock2;

    Worker2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            for (int i = 0; i < 100000000; i++) {
            }
            synchronized (lock1) {
                System.out.println("Exiting Worker1");
            }
        }
    }
}
