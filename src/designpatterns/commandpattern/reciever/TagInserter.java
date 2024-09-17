package designpatterns.commandpattern.reciever;

import designpatterns.commandpattern.data.Store;

public class TagInserter {
    public void insert(String tag){
        Store.add(tag);
    }
}
