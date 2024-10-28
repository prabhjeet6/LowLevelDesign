package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.challange1;

import basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.challange1.SequentialExecutionOfThreadsWithRounds;

public class Worker implements Runnable {
    @Override
    public void run() {

        while (rounds > 0) {
            while (compare()) {
            }
            System.out.println(val);
            synchronized (lock) {
                //we do not simply do current++ because otherwise once current reaches above
                // 9, repetitions will cease to happen
                SequentialExecutionOfThreadsWithRounds.current = (SequentialExecutionOfThreadsWithRounds.current + 1) % 10;
            }
            rounds--;
        }
    }

    private boolean compare() {
        boolean ans;
        synchronized (lock) {
            // if we had used 'ans = this.val > SequentialExecutionOfThreads.current;'
            //it would have resulted output in a haphazard manner
            // 0 0 1 1 2 3 2...
            //Here, reason is not race condition, because every thread  has its own copy of
            // 'rounds', which has a primitive datatype
            // It so happens because, in the run() method, we have an additional loop and
            // after the  condition commented above fails, nested while loop ends,
            // without a context switch, and 'val' is again printed with the same value.
            ans = !(this.val == SequentialExecutionOfThreadsWithRounds.current);
        }
        return ans;
    }


    private final int val;
    private final Object lock;
    private int rounds;


    public Worker(int val, Object lock, int rounds) {
        this.val = val;
        this.lock = lock;
        this.rounds = rounds;
    }
}
