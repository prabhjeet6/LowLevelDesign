package basics.concurrency.specialseries;

public class ZeroWorker implements Runnable {

    private final Object lock;

    public ZeroWorker(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (Main.current <= Main.n) {
                while (!(Main.current == 0 && Main.naturalNumber <= Main.n)) {
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
                Main.current = Main.naturalNumber;
                lock.notifyAll();
            }
        }
    }
}
