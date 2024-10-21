package basics.concurrency.memoryvisibilityandotherconcerns;

public class Worker implements Runnable {
    @Override
    public void run() {
        while (this.val > SequentialExecutionOfThreads.current) {}
        System.out.println(val);
        SequentialExecutionOfThreads.current++;

    }

    private final int val;

    public Worker(int val) {
        this.val = val;
    }
}
