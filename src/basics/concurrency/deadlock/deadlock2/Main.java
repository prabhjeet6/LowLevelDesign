package basics.concurrency.deadlock.deadlock2;

public class Main {
    public static void main(String[] ag) {
        Lock lock1 = new Lock(1);
        Lock lock2 = new Lock(2);
        Lock lock3 = new Lock(3);

        Thread thread1 = new Thread(new Worker(lock1, lock2));
        Thread thread2 = new Thread(new Worker(lock2, lock3));
        Thread thread3 = new Thread(new Worker(lock3, lock1));

        thread1.start();
        thread2.start();
        thread3.start();


    }

}
