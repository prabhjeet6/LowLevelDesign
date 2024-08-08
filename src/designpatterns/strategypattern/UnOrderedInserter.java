package designpatterns.strategypattern;

import java.util.List;

public class UnOrderedInserter implements Inserter{
    @Override
    public void insert(List<Integer> numbers, int number) {
        System.out.println("Inside UnOrderedInserter");
        numbers.add(number);
    }
}
