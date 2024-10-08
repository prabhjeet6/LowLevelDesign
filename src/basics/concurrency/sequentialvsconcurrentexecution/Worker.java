package basics.concurrency.sequentialvsconcurrentexecution;

import java.util.List;

public class Worker implements Runnable{
    private  final int startIndex;
    private  final int endIndex;
    private  final List<Integer> nums ;

    public Worker(int startIndex, int endIndex, List<Integer> nums) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.nums = nums;
    }

    @Override
    public void run() {
     long s=0L;
     for(int i=startIndex;i<=endIndex;i++){
         s+=nums.get(i);
         //Main.sum.addAndGet(nums.get(i));  higher number of context switches hence completion time
         // for concurrent sum will increase
     }
     Main.sum.addAndGet(s);
     Main.count.incrementAndGet();
    }
}
