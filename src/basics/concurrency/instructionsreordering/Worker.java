package basics.concurrency.instructionsreordering;

public class Worker implements Runnable{
    private final NumStore numStore;
    Worker( NumStore numStore){
        this.numStore = numStore;
    }

    @Override
    public void run() {
        numStore.increment();
    }
}
