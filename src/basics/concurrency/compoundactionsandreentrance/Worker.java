package basics.concurrency.compoundactionsandreentrance;

class Worker implements Runnable{
 private final Number number;

    Worker(Number number) {
        this.number = number;
    }

    @Override
    public void run() {
     number.increment();
    }
}
