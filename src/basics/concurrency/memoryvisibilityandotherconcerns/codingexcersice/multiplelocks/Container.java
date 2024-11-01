package basics.concurrency.memoryvisibilityandotherconcerns.codingexcersice.multiplelocks;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<Integer> nums;

    private int curr;

    public Container(List<Integer> nums) {
        this.nums=new ArrayList<>();
        for(int i=1;i<=100;i++){
           this.nums.add(i);
        }
        this.curr=0;
    }

    public synchronized int pluck(){
        if(curr==nums.size()){
            return -1;
        }
        int val=nums.get(curr);
        curr++;
        return val;
    }
}
