package basics.concurrency.deadlock.deadlock2;

public class Worker implements Runnable {
    private final Lock lock1, lock2;

    public Worker(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        //we order locks in natural order of Ids here, to avoid deadlock as they are getting
        // called in a cyclic order in Main class
        Lock l1, l2;
        if (lock1.getId() > lock2.getId()) {
            l1 = lock1;
            l2 = lock2;
        } else {
            l1 = lock2;
            l2 = lock1;
        }
        synchronized (l1) {
            synchronized (l2) {
                System.out.println("Exiting Worker");
            }
        }
    }
}
