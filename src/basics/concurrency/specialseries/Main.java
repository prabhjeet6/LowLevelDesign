package basics.concurrency.specialseries;

public class Main {
    public static final int n=4;
    public static  int current=0,naturalNumber=1;
    public static void main(String[] as){

        Object lock=new Object();
        Thread zero=new Thread(new ZeroWorker(lock));
        zero.start();
        Thread even=new Thread(new EvenWorker(lock));
        even.start();
        Thread odd=new Thread(new OddWorker(lock));
        odd.start();
    }

}
