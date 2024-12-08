package basics.concurrency.producerconsumer;

public class Producer implements Runnable {
    private final MyQueue queue;

    public Producer(MyQueue myQueue) {
        this.queue = myQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            synchronized (queue) {
                while (queue.isFull()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.push(i);
                System.out.println("Producer produced " + i);
                queue.notifyAll();
            }

        }
        //Producer has produced all values from i=0 to i<500, now producing -1 outside the
        // loop to indicate that consumer can terminate upon receiving -1
        synchronized (queue) {
            //wait if the queue is full, else push to queue, as queue is a shared resource,
            // operate upon it only inside a synchronized block

            //In case of multiple producers, if queue is full, and consumer pops up, and two producers get notified, one producer pushes and then the
            //second producer tries pushing, it throws exception since the queue is full now, hence we use while loop at line 35 instead of only if check
            while (queue.isFull()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
            queue.push(-1);
            System.out.println("Producer produced -1");
            //notify to other threads, once done
            queue.notifyAll();
        }
    }
}
