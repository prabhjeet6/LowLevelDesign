package basics.concurrency.fizzbuzz;

public class Fizz implements Runnable {

    private final Object lock;
    private final String name;

    public Fizz(String name, Object lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock){
            while(FizzBuzzSimulator.curr <= FizzBuzzSimulator.total){
                if(FizzBuzzSimulator.curr%5 != 0 && FizzBuzzSimulator.curr%3 == 0){
                    System.out.println(FizzBuzzSimulator.curr + " " + name);
                    FizzBuzzSimulator.curr++;
                    lock.notifyAll();
                }
                else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}