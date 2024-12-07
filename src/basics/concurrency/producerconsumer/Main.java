package basics.concurrency.producerconsumer;


public class Main {

    public static int count = 2;

    public static void main(String[] a) {

        MyQueue myQueue = new MyQueue(50);
        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        /*Producer producer2 = new Producer(myQueue);
        Consumer consumer2 = new Consumer(myQueue);

        Thread producerThread2 = new Thread(producer2);
        Thread consumerThread2 = new Thread(consumer2);*/

        producerThread.start();
        consumerThread.start();
       /* producerThread2.start();
        consumerThread2.start();*/

    }
}
