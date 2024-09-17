package designpatterns.commandpattern.cmd;


import designpatterns.commandpattern.data.IStore;
import designpatterns.commandpattern.data.IStoreImpl;
import designpatterns.commandpattern.reciever.PartialMatchDeleter;
import designpatterns.commandpattern.reciever.PerfectMatchDeleter;
import designpatterns.commandpattern.reciever.TagInserter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CommandFactory {

    private static PartialMatchDeleter partialMatchDeleter;
    private static List<String> deletedTags;
    private static TagInserter tagInserter;
    private static PerfectMatchDeleter perfectMatchDeleter;
    private static volatile CommandFactory INSTANCE = null;

    private CommandFactory(PartialMatchDeleter pamd, List<String> dt, TagInserter ti, PerfectMatchDeleter pemd) {
        partialMatchDeleter = pamd;
        deletedTags = dt;
        tagInserter = ti;
        perfectMatchDeleter = pemd;
    }

    public static CommandFactory getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (CommandFactory.class) {
                if (INSTANCE == null) {
                    IStore iStore = new IStoreImpl();
                    TagInserter tagInserter = new TagInserter();
                    List<String> deletedTags = new ArrayList<>();
                    PerfectMatchDeleter perfectMatchDeleter = new PerfectMatchDeleter(iStore);
                    PartialMatchDeleter partialMatchDeleter = new PartialMatchDeleter(iStore);
                    INSTANCE = new CommandFactory(partialMatchDeleter, deletedTags, tagInserter, perfectMatchDeleter);
                }

            }
        }
        return INSTANCE;
    }


    public Command getPartialMatchDeleteCmd(Pattern pattern) {
        return new PartialMatchDeleterCommand(pattern, partialMatchDeleter, tagInserter, deletedTags);
    }

    public Command getPerfectMatchDeleteCmd(String name) {
        return new PerfectMatchDeleterCommand(name, tagInserter, perfectMatchDeleter, deletedTags);
    }

    public Command getInsertTagCmd(String name) {
        return new InsertTagCommand(name, tagInserter, perfectMatchDeleter);
    }
}
