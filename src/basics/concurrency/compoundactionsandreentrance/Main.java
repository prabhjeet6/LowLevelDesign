package basics.concurrency.compoundactionsandreentrance;

public class Main {
    public static void main(String [] as) throws InterruptedException {
     Number number=new Number();
     Worker worker=new Worker(number);
     Thread t1=new Thread(worker);
     Thread t2=new Thread(worker);
     t1.start();
     t2.start();
     t1.join();//main thread waits until t1 finishes
     t2.join();
     System.out.println(number.getX());



    }
}
