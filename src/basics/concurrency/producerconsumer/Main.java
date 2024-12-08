package basics.concurrency.producerconsumer;


public class Main {

    public static int producerCount = 3;

    public static void main(String[] a) {

        MyQueue myQueue = new MyQueue(50);
        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);


        Thread producerThread2 = new Thread(producer);
        Thread consumerThread2 = new Thread(consumer);

        Thread consumerThread3 = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
        producerThread2.start();
        consumerThread2.start();

        consumerThread3.start();

    }
}
