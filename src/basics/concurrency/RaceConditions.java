package basics.concurrency;

public class RaceConditions {
    public static void main(String[] a) throws InterruptedException {
        NumberStore numberStore = new NumberStore();
        Thread t1=new Thread(new Worker(numberStore));
        Thread t2=new Thread(new Worker(numberStore));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(numberStore.getX());

    }
}
 class Worker implements Runnable {

    NumberStore numberStore;
    public Worker(NumberStore numberStore){
        this.numberStore = numberStore;
    }

    @Override
    public void run() {

        for(int i = 0;i<100000;i++){
            numberStore.increment();
        }
    }
}
class NumberStore{
    long x;
    public  void increment(){
        //Due to race conditions we do not get the desired value
        //adding the increment operation in synchronized block or marking
        // the method itself as synchronized resolves the issue
        x++;
    }
    NumberStore(){
        this.x=0;
    }


    public long getX() {
        return x;
    }
}
