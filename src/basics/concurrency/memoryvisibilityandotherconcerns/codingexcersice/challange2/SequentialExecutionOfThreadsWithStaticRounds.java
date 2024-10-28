package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.challange2;

public class SequentialExecutionOfThreadsWithStaticRounds {
    //Using current=0 instead of 1 as in  'SequentialExcecutionOfThreads'
    static  int  current = 0;
    public static int rounds=3;
    //Here, we are trying to use the code from 'SequentialExcecutionOfThreads' and
    // run it in multiple rounds
    //0 1 2 3...9 0 1 2 3...9 0 1 2 3...9
    public static void main(String[] a) {
        Object lock=new Object();
        Thread one = new Thread(new Worker(0,lock));
        Thread two = new Thread(new Worker(1,lock));
        Thread three = new Thread(new Worker(2,lock));
        Thread four = new Thread(new Worker(3,lock));
        Thread five = new Thread(new Worker(4,lock));
        Thread six = new Thread(new Worker(5,lock));
        Thread seven = new Thread(new Worker(6,lock));
        Thread eight = new Thread(new Worker(7,lock));
        Thread nine = new Thread(new Worker(8,lock));
        Thread ten = new Thread(new Worker(9,lock));
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
