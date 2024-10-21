package basics.concurrency.instructionsreordering;

public class Main {
    public static void main(String[] a) throws InterruptedException {
        NumStore numStore = new NumStore();
        //there is only one writer thread and one reader thread(main),once the writer thread stops only then a new
        //thread starts to operate, hence, there is no Race condition here, still, there 'may' be  some lines
        //printed here and that could be because of two possible reasons
        //1. Memory visibility issue
        //2. instructions reordering by JVM for optimizations
        //To avoid the above two issues, we can mark every getter and increment method in NumStore as synchronized
        for (int i = 0; i < 10000000; i++) {
            Thread thread = new Thread(new Worker(numStore));
            int curr = numStore.getX();
            thread.start();
            while (curr == numStore.getW()) {
            }
            if (!(numStore.getX() == numStore.getY() && numStore.getY() == numStore.getZ() && numStore.getZ() == numStore.getW())) {
                System.out.println(numStore.getX() + " " + numStore.getY() + " " + numStore.getZ() + " " + numStore.getW());
            }
            thread.join();
        }

    }

}
