package basics.concurrency;

public class RaceConditions {
    public static void main(String[] a) throws InterruptedException {
        NumberStore numberStore = new NumberStore();
        Thread t1 = new Thread(new Worker(numberStore));
        Thread t2 = new Thread(new Worker(numberStore));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(numberStore.getX());

    }
}

class Worker implements Runnable {

    NumberStore numberStore;

    public Worker(NumberStore numberStore) {
        this.numberStore = numberStore;
    }

// Marking a method or code block as synchronized makes it execute the code sequentially and  not concurrently
//We have marked NumberStore's increment method as synchronized in the below comments, instead of marking
// increment method as synchronized, if we mark worker's run method instead, as it will still keep the critical
//section synchronized, but it will degrade performance as more than required code will be run sequentially. for
// example, line number 33 which could run concurrently if only increment method is synchronized
    @Override
    public void run() {

        for (int i = 0; i < 100000; i++) {
            numberStore.increment();
        }
    }
}

class NumberStore {
    long x;

    public void increment() {
        //Due to race conditions we do not get the desired value
        //adding the increment operation in synchronized block or marking
        // the method itself as synchronized resolves the issue

        x++;
    }

    /*
    //if a synchronized block is placed on an Object and different objects are passed in worker's NumberStore
    //reference, then locks will be on different objects hence, two threads will be able to access
    //critical section simultaneously

    public  void increment(Object  o){
       synchronized(o){
        x++;
        }
    }*/
    NumberStore() {
        this.x = 0;
    }


    public long getX() {
        return x;
    }
}
