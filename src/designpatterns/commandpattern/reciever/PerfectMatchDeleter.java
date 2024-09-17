package designpatterns.commandpattern.reciever;

import designpatterns.commandpattern.data.IStore;

import java.util.ArrayList;
import java.util.List;

public class PerfectMatchDeleter {
    private final IStore iStore;

    public PerfectMatchDeleter(IStore iStore) {
        this.iStore = iStore;
    }

    public List<String> delete(String tag) {
        if (null == tag || tag.isEmpty()) {
            throw new RuntimeException("Illegal Tag Passed; can't be deleted");
        }
        List<String> tags = new ArrayList<>(iStore.getTags());
        List<String> deletedStrings = new ArrayList<>();
        for (String tg : tags) {
            if (tag.equals(tg)) {
                iStore.delete(tag);
                deletedStrings.add(tag);
            }
        }
        return deletedStrings;
    }
}