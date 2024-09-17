package designpatterns.commandpattern.api;

import designpatterns.commandpattern.cmd.Command;
import designpatterns.commandpattern.cmd.CommandFactory;
import designpatterns.commandpattern.data.MatchType;

import java.util.regex.Pattern;

public class DeleteTagsAPI {


    public void deleteTags(String input, MatchType matchType) {
        CommandFactory commandFactory = CommandFactory.getINSTANCE();
        Command command=null;
        if (matchType.equals(MatchType.PARTIAL)) {
            Pattern pattern = Pattern.compile(input);
            command=commandFactory.getPartialMatchDeleteCmd(pattern);
        } else {
            command=commandFactory.getPerfectMatchDeleteCmd(input);
        }
        command.execute();

    }

}
