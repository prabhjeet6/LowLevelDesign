package designpatterns.commandpattern.cmd;

import designpatterns.commandpattern.reciever.PerfectMatchDeleter;
import designpatterns.commandpattern.reciever.TagInserter;

import java.util.List;

public class PerfectMatchDeleterCommand implements Command {
    private final String tag;
    private final TagInserter tagInserter;
    private final PerfectMatchDeleter perfectMatchDeleter;
    private final List<String> deletedTags;

    public PerfectMatchDeleterCommand(String tag, TagInserter tagInserter, PerfectMatchDeleter perfectMatchDeleter, List<String> deletedTags) {
        this.tag = tag;
        this.tagInserter = tagInserter;
        this.perfectMatchDeleter = perfectMatchDeleter;
        this.deletedTags = deletedTags;
    }

    @Override
    public void execute() {
        List<String> deletedTags = this.perfectMatchDeleter.delete(this.tag);
        this.deletedTags.addAll(deletedTags);
    }

    @Override
    public void undo() {
        for (String tag : this.deletedTags) {
            this.tagInserter.insert(tag);
        }
        this.deletedTags.clear();
    }
}
