package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.multiplelocks;

public class Worker implements Runnable {

    private final Container container;
    private final Object lock;

    public Worker(Container container, Object lock) {
        this.container = container;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            int x = container.pluck();//lock1
            if (x == -1) {
                break;
            }
            synchronized (lock) {//lock 2
                Main.sum += x;
            }
            //both statements are independent of each other, hence,using separate lock makes sense to improve performance
        }
    }
}
