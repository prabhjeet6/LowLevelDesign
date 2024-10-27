package basics.concurrency.memoryvisibilityandotherconcerns.sequentialexecutionwithoutvolatile;

public class SequentialExecutionOfThreads {
    static  int  current = 1;
    //Here we are not using volatile keyword and rather using an  Object lock,
    // on critical section
    public static void main(String[] a) {
        Object lock=new Object();
        Thread one = new Thread(new Worker(1,lock));
        Thread two = new Thread(new Worker(2,lock));
        Thread three = new Thread(new Worker(3,lock));
        Thread four = new Thread(new Worker(4,lock));
        Thread five = new Thread(new Worker(5,lock));
        Thread six = new Thread(new Worker(6,lock));
        Thread seven = new Thread(new Worker(7,lock));
        Thread eight = new Thread(new Worker(8,lock));
        Thread nine = new Thread(new Worker(9,lock));
        Thread ten = new Thread(new Worker(10,lock));
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();
        seven.start();
        eight.start();
        nine.start();
        ten.start();
    }
}
