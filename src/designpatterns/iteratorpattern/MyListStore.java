package designpatterns.iteratorpattern;

import java.util.ArrayList;
import java.util.List;

public class MyListStore implements Iterable {
    private final List<Integer> internalList;

    public MyListStore() {
        this.internalList = new ArrayList<>();
    }

    public void insert(Integer x) {
        this.internalList.add(x);
    }

    @Override
    public Iterator getIterator() {
        return new MyListIterator(this.internalList);
    }
}
