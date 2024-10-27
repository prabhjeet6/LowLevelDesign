package basics.concurrency.memoryvisibilityandotherconcerns.sequentialexecutionwithoutvolatile;

public class Worker implements Runnable {
    @Override
    public void run() {
        //if we  had synchronized the whole loop instead of the comparison condition,
        // After the execution of first thread,current  would have been 1 and any other
        // thread lets say with val=5 would have got this lock, then it would be stuck in
        // this infinite loop, and at the same time no other thread would have been able
        // to access this lock, hence, no other thread would have progressed. Please note,
        // that this is not memory visibility issue, this would have been incorrect
        //usage of locks

        //main thread gets same treatment as others. When CPU executes any line of code,
        // it reads the instructions and data , these instructions are fetched from RAM
        //  and stored in registers so that CPU can actually read it.
        while (compare()) {
        }
        System.out.println(val);
        synchronized (lock) {
            SequentialExecutionOfThreads.current++;
        }

    }

    private boolean compare() {
        boolean ans;
        synchronized (lock) {
            ans = this.val > SequentialExecutionOfThreads.current;
        }
        return ans;
    }


    private final int val;
    private final Object lock;


    public Worker(int val, Object lock) {
        this.val = val;
        this.lock = lock;
    }
}
