package designpatterns.strategypattern;

import java.util.Collections;
import java.util.List;

public class OrderedInserter implements Inserter{
    @Override
    public void insert(List<Integer> numbers, int number) {
        System.out.println("Inside OrderedInserter");
        numbers.add(number);
        Collections.sort(numbers);
    }
}
