package basics.concurrency.deadlock.deadlock1;

public class Main {
    public static void main(String[] arg) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        //Deadlock is created by passing arguments in different order
        //It can be fixed by acquiring locks in the same order
        //Deadlock occurs whenever there is a cyclic dependency
        //for example, if we have three threads t1,t2,t3
        // t1 needs a resource which is locked by t2. t2 needs a resource
        //which is locked by t3. t3 needs a resource locked by t1. this will create a deadlock
        Thread thread1 = new Thread(new Worker(lock1, lock2));
        Thread thread2 = new Thread(new Worker2(lock2, lock1));
        thread1.start();
        thread2.start();


    }

}
