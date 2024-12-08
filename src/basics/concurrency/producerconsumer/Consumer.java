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
                //In case of multiple consumer, if queue is empty, and producer pushes, and two consumers get notified, one consumer pops up and then the
                //second consumer tries popping, it throws exception since the queue is empty now, hence we use while loop at line 16 instead of only if check

                //Main.producerCount is used in case number of producers and consumers are different for example , if we have 3 consumers and two producers
                // a couple of consumers terminated because they received -1 from both producers subsequently, then third consumer will be stuck in
                // the infinite loop if it does not know the number of producers remaining

                while (queue.isEmpty() && Main.producerCount > 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (Main.producerCount == 0) {
                    queue.notifyAll();
                    break;
                }
                int val = queue.pop();
                System.out.println("Consumer consumed  " + val);
                queue.notifyAll();
                if (val == -1) {
                    Main.producerCount--;
                    break;
                }
            }
        }
    }
}
