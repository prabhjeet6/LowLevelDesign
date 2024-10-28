package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.challange1;

public class SequentialExecutionOfThreadsWithRounds {
    //Using current=0 instead of 1 as in the previous 'SequentialExcecutionOfThreads'
    static  int  current = 0;

    //Here, we are trying to use the code from 'SequentialExcecutionOfThreads' and
    // run it in multiple rounds
    //0 1 2 3...9 0 1 2 3...9 0 1 2 3...9
    public static void main(String[] a) {
        Object lock=new Object();
        int rounds=3;
        Thread one = new Thread(new Worker(0,lock,rounds));
        Thread two = new Thread(new Worker(1,lock,rounds));
        Thread three = new Thread(new Worker(2,lock,rounds));
        Thread four = new Thread(new Worker(3,lock,rounds));
        Thread five = new Thread(new Worker(4,lock,rounds));
        Thread six = new Thread(new Worker(5,lock,rounds));
        Thread seven = new Thread(new Worker(6,lock,rounds));
        Thread eight = new Thread(new Worker(7,lock,rounds));
        Thread nine = new Thread(new Worker(8,lock,rounds));
        Thread ten = new Thread(new Worker(9,lock,rounds));
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
