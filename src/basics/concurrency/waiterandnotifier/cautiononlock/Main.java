package basics.concurrency.waiterandnotifier.cautiononlock;

public class Main {

    //Despite the lock ref being different for Notifier and waiter, they are able to wait and
    //notify because of Java's String constant pool. We should be cautious while defining locks
    public static void main(String[] arg) {
        Thread waiter = new Thread(new Waiter());
        Thread notifier = new Thread(new Notifier());
        waiter.start();
        notifier.start();
    }

}
