package designexamples.fooddeliveryapp.data;

public enum StarRating {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5);

    int val;

    StarRating(int val){
        this.val=val;
    }
    public int getVal(){
        return this.val;
    }


}
