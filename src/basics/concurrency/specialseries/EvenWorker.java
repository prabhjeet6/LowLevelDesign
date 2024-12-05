package basics.concurrency.specialseries;

public class EvenWorker implements Runnable {
    private final Object lock;

    public EvenWorker(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (Main.current <= Main.n) {
                while (!(Main.current > 0 && Main.current % 2 == 0) && Main.naturalNumber <= Main.n) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (Main.naturalNumber > Main.n) {
                    lock.notifyAll();
                    break;
                }

                System.out.println(Main.current);
                Main.current = 0;
                Main.naturalNumber++;
                lock.notifyAll();

            }
        }
    }
}
