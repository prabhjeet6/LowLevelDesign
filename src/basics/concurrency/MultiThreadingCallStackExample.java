package basics.concurrency;

public class MultiThreadingCallStackExample {
    public static int  func2(){
        return 0;
    }
    public static int func1(){
        int x=func2();
        if(x==0){
            throw new RuntimeException();
        }
        return x;
    }
    public static void main(String []as){
        try {
            Thread threadRunningMyRunnable = new Thread(new MyRunnable());
            threadRunningMyRunnable.start();
        }catch(Exception e){
            //This exception is never thrown as threadRunningMyRunnable throws RuntimeException
            // in its own callstack where MyRunnable is running
            System.out.print("Exception in main Thread");
        }
    }

}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException("Exception in call stack of Thread running MyRunnable ");
    }
}

