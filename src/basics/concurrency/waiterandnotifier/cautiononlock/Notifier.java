package basics.concurrency.waiterandnotifier.cautiononlock;

public class Notifier implements Runnable {
    private final String notifierLock = "abc";

    @Override
    public void run() {
        synchronized (notifierLock) {
            notifierLock.notifyAll();
            System.out.println("Notifier exiting");
        }
    }
}
