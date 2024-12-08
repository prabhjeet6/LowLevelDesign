package basics.concurrency.deadlock.deadlock2;

public class Lock {
    private final int id;

    public Lock(int id) {
        this.id = id;
    }


    public int getId() {
        return this.id;
    }

}
