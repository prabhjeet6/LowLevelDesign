package designpatterns.commandpattern.reciever;

import designpatterns.commandpattern.data.IStore;
import designpatterns.commandpattern.data.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleter {
    private final IStore iStore;

    public PartialMatchDeleter(IStore iStore) {
        this.iStore = iStore;
    }

    public List<String> delete(Pattern pattern) {
        List<String> tags = new ArrayList<>(iStore.getTags());
        List<String> deletedStrings = new ArrayList<>();
        for (String tag : tags) {
            if (pattern.matcher(tag).matches()) {
                iStore.delete(tag);
                deletedStrings.add(tag);
            }
        }
        return deletedStrings;

    }
}
