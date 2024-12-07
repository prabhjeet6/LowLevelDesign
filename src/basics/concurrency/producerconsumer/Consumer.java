package basics.concurrency.producerconsumer;

public class Consumer implements Runnable {
    private final MyQueue queue;

    public Consumer(MyQueue myQueue) {
        this.queue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                int val = queue.pop();
                System.out.println("Consumer consumed  " + val);
                queue.notifyAll();
                if (val == -1) {
                    break;
                }
            }
        }
    }
}
