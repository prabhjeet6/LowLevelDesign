package designpatterns.commandpattern.cmd;

import designpatterns.commandpattern.reciever.PerfectMatchDeleter;
import designpatterns.commandpattern.reciever.TagInserter;

public class InsertTagCommand implements Command {
    private final String tag;
    private final TagInserter tagInserter;
    private final PerfectMatchDeleter perfectMatchDeleter;

    public InsertTagCommand(String tag, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter) {
        this.tag = tag;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
    }

    @Override
    public void execute() {
        this.tagInserter.insert(this.tag);
    }

    @Override
    public void undo() {
        this.perfectMatchDeleter.delete(tag);
    }
}
