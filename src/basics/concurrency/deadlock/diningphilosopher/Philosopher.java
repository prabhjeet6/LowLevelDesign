package basics.concurrency.deadlock.diningphilosopher;

public class Philosopher implements Runnable{

    private final Chopstick left,right;
    private final String name;

    public Philosopher(Chopstick left, Chopstick right, String name) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
      while(true){
          System.out.println("Philosopher "+ name+" is Thinking..");
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
          //sequential locking prevents deadlock
          Chopstick c1,c2;
          if(left.getId()<right.getId()){
              c1=left;
              c2=right;
          }else {
              c1=right;
              c2=left;
          }
          synchronized (c1){
              synchronized (c2){
                  System.out.println("Philosopher "+ name+" is Dining..");
                  try {
                      Thread.sleep(2000);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  right.notifyAll();
              }
              left.notifyAll();
          }
      }
    }
}
