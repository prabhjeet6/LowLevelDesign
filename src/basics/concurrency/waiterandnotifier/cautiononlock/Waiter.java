package basics.concurrency.waiterandnotifier.cautiononlock;

public class Waiter  implements Runnable{
   final String waiterLock="abc";
    @Override
    public void run() {
     synchronized (waiterLock){
         try {
             waiterLock.wait();
         } catch (InterruptedException e) {
             throw new RuntimeException(e);
         }
         System.out.println("Waiter Exiting");
     }
    }
}
