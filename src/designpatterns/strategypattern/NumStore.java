package designpatterns.strategypattern;

import java.util.ArrayList;
import java.util.List;

//Problem Statement: Create a NumStore that stores and searches numbers according to the choice of
// client using this class

//Dynamically chooses the strategy for search and insert and search at runtime

// This code satisfies SOLID principles, specifically, open close principle and Dependency Injection principle
public class   NumStore {
    private final Inserter inserter;
    private final Searcher searcher;
    private final List<Integer> numbers=new ArrayList<>();


    public NumStore(Inserter inserter, Searcher searcher) {
        this.inserter = inserter;
        this.searcher = searcher;
    }
    public void insert(int number){
        this.inserter.insert(this.numbers,number);
    }
    public int search(int number){
       return this.searcher.search(this.numbers,number);
    }
}
