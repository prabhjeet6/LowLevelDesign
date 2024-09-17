package designpatterns.commandpattern.data;

import java.util.List;

public class IStoreImpl implements IStore {
    @Override
    public void delete(String tag) {
        Store.delete(tag);
    }

    @Override
    public void add(String tag) {
        Store.add(tag);
    }

    @Override
    public List<String> getTags() {
        return Store.getTags();
    }
}
