package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.oddeven;

public class EvenWorker implements Runnable {
    private final String name;
    private final Object lock;

    public EvenWorker(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        /*while (Main.current < Main.limit) {
            if (Main.current % 2 == 0) {
                System.out.println("Even Worker :" + Main.current);
                Main.current++;
            }
        }*/
        while (true) {
            synchronized (lock) {
                if (Main.current > Main.limit) {
                    break;
                }
                if (Main.current % 2 == 0) {
                    System.out.println("Even Worker :" + Main.current);
                    Main.current++;
                }
            }
        }
    }

}
