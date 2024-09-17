package designpatterns.commandpattern.data;

import java.util.List;

public interface IStore {
    void delete(String tag);

    void add(String tag);

    List<String> getTags();
}
