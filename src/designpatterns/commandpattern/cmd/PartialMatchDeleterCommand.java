package designpatterns.commandpattern.cmd;

import designpatterns.commandpattern.reciever.PartialMatchDeleter;
import designpatterns.commandpattern.reciever.TagInserter;

import java.util.List;
import java.util.regex.Pattern;

public class PartialMatchDeleterCommand implements Command {

    private final Pattern pattern;
    private final PartialMatchDeleter partialMatchDeleter;
    private final TagInserter tagInserter;
    private final List<String> deletedTags;

    public PartialMatchDeleterCommand(Pattern pattern, PartialMatchDeleter partialMatchDeleter, TagInserter tagInserter, List<String> deletedTags) {
        this.pattern = pattern;
        this.partialMatchDeleter = partialMatchDeleter;
        this.tagInserter = tagInserter;
        this.deletedTags = deletedTags;
    }

    @Override
    public void execute() {
        List<String> deletedTags = this.partialMatchDeleter.delete(this.pattern);
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
