package designpatterns.commandpattern;


import designpatterns.commandpattern.api.DeleteTagsAPI;
import designpatterns.commandpattern.data.MatchType;

public class TagsChangeSimulator {

    public static void main(String[] args) {

        new DeleteTagsAPI().deleteTags("Math.*",
         MatchType.PARTIAL);



    }


}
