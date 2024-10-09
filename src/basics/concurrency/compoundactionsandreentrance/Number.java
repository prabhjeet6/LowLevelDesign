package basics.concurrency.compoundactionsandreentrance;

class Number {
    Number() {
        x = 0;
    }

    int x;

    public synchronized int getX() {
        return x;
    }

    public synchronized void setX(int x) {
        this.x = x;
    }

    //Compound Action: atomic, synchronized, No other thread can access increment() unless all three
    // locks are withdrawn
    public synchronized void increment() { //enters a lock
        //In Order for the compound action to be atomic, not only actions individually should be atomic,
        //but, also, atomic together
        int oldValue = getX();//atomic, synchronized, re-enters another lock
        setX(oldValue + 1); //atomic, synchronized, re-enters another lock
    }
    //if increment method was not synchronized, then these individual actions at line
    // 18 and 19 being atomic won't make increment atomic

    //In the code below context switch is possible hence it gives output 1 instead of 2 as one of
    // the two threads get stale value

    /*public void increment(){
    try{
        int oldValue=getX();
        Thread.sleep(200); //context switch happens here
        setX(oldValue+1);
        }catch(InterruptedException e){}
    }
    * */
}
