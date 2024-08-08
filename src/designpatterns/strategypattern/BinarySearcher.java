package designpatterns.strategypattern;

import java.util.Collections;
import java.util.List;

public class BinarySearcher implements Searcher{
    @Override
    public int search(List<Integer> numbers, int number) {
        System.out.println("Inside BinarySearcher");
        return Collections.binarySearch(numbers,number);
    }
}
