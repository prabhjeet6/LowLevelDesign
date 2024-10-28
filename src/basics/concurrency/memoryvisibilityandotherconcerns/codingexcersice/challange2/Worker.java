package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.challange2;

public class Worker implements Runnable {
    @Override
    public void run() {

        while (SequentialExecutionOfThreadsWithStaticRounds.rounds > 0) {
            while (compare()) {
            }
            //because ' rounds' is shared variable now, we put the compound actions in a
            // synchronized block together
            synchronized (lock) {
                if (SequentialExecutionOfThreadsWithStaticRounds.rounds == 0)
                    //if all the rounds are finished, it means, we need to break
                    break;
                System.out.println(val);
                //we do not simply do current++ because otherwise once current reaches above
                // 9, repetitions will cease to happen
                SequentialExecutionOfThreadsWithStaticRounds.current = (SequentialExecutionOfThreadsWithStaticRounds.current + 1) % 10;
                if (SequentialExecutionOfThreadsWithStaticRounds.current == 0) {
                    //if current again reaches to zero,It means one round has finished.
                    SequentialExecutionOfThreadsWithStaticRounds.rounds--;
                }
            }

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
            ans = !(this.val == SequentialExecutionOfThreadsWithStaticRounds.current)&&!(SequentialExecutionOfThreadsWithStaticRounds.rounds==0);
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
