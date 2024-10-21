package basics.concurrency.memoryvisibilityandotherconcerns;

public class SequentialExecutionOfThreads {
    static volatile int  current = 1;
    //sometimes, 'current's value may get changed by a thread, but, it is not updated in the RAM
    // as a result of which other threads keep on waiting in the while loop and program gets stuck, this is called
    // Memory visibility Problem.  the solution to this is to mark the variable as volatile. volatile keyword
    // indicates that memory is immediately flushed into RAm and the program never gets stuck.
    // The volatile keyword in Java is used to mark a Java variable as “being stored in main memory”.

    //Registers:
    //Small, fast storage locations within the CPU that temporarily store data being processed.
    // Registers are part of the CPU's cache, which is the fastest part of the CPU cache.
    //Registers are part of Primary memory.
    // Primary memory:
    //The working memory of a computer, which is faster than secondary memory.
    // Other examples of primary memory include RAM, ROM, cache, PROM, and EPROM
    //Registers are part of the CPU, while RAM is separate

    public static void main(String[] a) {
        Thread one = new Thread(new Worker(1));
        Thread two = new Thread(new Worker(2));
        Thread three = new Thread(new Worker(3));
        Thread four = new Thread(new Worker(4));
        Thread five = new Thread(new Worker(5));
        Thread six = new Thread(new Worker(6));
        Thread seven = new Thread(new Worker(7));
        Thread eight = new Thread(new Worker(8));
        Thread nine = new Thread(new Worker(9));
        Thread ten = new Thread(new Worker(10));
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
