package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.oddeven;

public class Main {
     public static final int limit=20;
     public static volatile int current=1;
    public static void main(String[]a){
        Object lock=new Object();
        Thread oddThread=new Thread(new OddWorker("Odd Worker",lock));
        Thread evenThread=new Thread(new EvenWorker("Even Worker",lock));
        oddThread.start();
        evenThread.start();
    }


}
