package basics.concurrency.sequentialvsconcurrentexecution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static AtomicLong sum = new AtomicLong(0);
    public static AtomicInteger count = new AtomicInteger(0);


    public static void concurrentSum(List<Integer> nums) {
        int size = 10000000 / 4;
        Thread t1 = new Thread(new Worker(0, size - 1, nums));
        Thread t2 = new Thread(new Worker(size, 2 * size - 1, nums));
        Thread t3 = new Thread(new Worker(2 * size, 3 * size - 1, nums));
        Thread t4 = new Thread(new Worker(3 * size, 4 * size - 1, nums));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Busy waiting
        while (count.get() < 4) {
        }
        System.out.println("sum concurrent:"+sum.get());
        System.out.println("count concurrent:"+count.get());

    }

    public static void sequentialSum(List<Integer> nums) {
        long sum=0L;
        for (int i = 0; i < nums.size(); i++) {
            sum+=nums.get(i);

        }
        //count.incrementAndGet();
        System.out.println("sum seq:"+sum);
        //System.out.println("count seq: "+count.get());
    }

    public static void main(String[] as) {
        List<Integer> nums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            nums.add(random.nextInt());
        }
        long startTimeStampSeq = System.currentTimeMillis();
        sequentialSum(nums);
        long stopTimeStampSeq = System.currentTimeMillis();
        System.out.println("Sequential: " + (stopTimeStampSeq - startTimeStampSeq));

        long startTimeStamp = System.currentTimeMillis();
        concurrentSum(nums);
        long stopTimeStamp = System.currentTimeMillis();
        System.out.println("concurrent: " + (stopTimeStamp - startTimeStamp));
    }

}
