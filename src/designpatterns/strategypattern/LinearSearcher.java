package designpatterns.strategypattern;

import java.util.List;

public class LinearSearcher implements Searcher{
    private boolean found=false;
    private int numberIndex;
    @Override
    public int search(List<Integer> numbers, int number) {
        clearPrevValues();
        System.out.println("Inside LinearSearcher");
        for(int i=0;i<numbers.size();i++){
            if(numbers.get(i)==number){
                found=true;
                numberIndex= i;
                break;
            }
        }
        if(!found){
            numberIndex= -1;
        }

        return numberIndex;
    }

    private void clearPrevValues() {
        this.found=false;
        this.numberIndex=0;
    }
}
