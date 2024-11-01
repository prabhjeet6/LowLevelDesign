package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.oddeven;

public class OddWorker implements Runnable {
    private final String name;
    private final Object lock;

    public OddWorker(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        //when we use workers without lock and synchronized blocks with commented code as
        // below, program becomes stuck due to memory visibility issue
        // We make Main.current volatile to mitigate this.
        //However, it runs fine intermittently, because the commented code is a compound action
        // ,and we have not guarded it, hence, race conditions can occur.
        // Let's say, after 20 is printed, and current value becomes 21 after increment, and
        //context switch happens, and OddWorker resumes inside while loop, it will eventually
        //print 21, even though current is beyond limit.

        /* while (Main.current < Main.limit) {
            if (Main.current % 2 != 0) {
                System.out.println("Odd Worker :" + Main.current);
                Main.current++;
            }
        }*/
        //the above scenario is mitigated with the help of below code adding a lock and a
        // check Main.current > Main.limit  in order to break if the condition is true.
        while (true) {
            synchronized (lock) {
                if (Main.current > Main.limit) {
                    break;
                }
                if (Main.current % 2 != 0) {
                    System.out.println("Odd Worker :" + Main.current);
                    Main.current++;
                }
            }
        }
    }
}
