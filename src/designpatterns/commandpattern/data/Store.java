package designpatterns.commandpattern.data;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static List<String> tags = new ArrayList<>() {
        {
            add("Knapsack");
            add("Math");
            add("Mathematics");
            add("sieve");
            add("runtime error");
            add("sieve-of-eratosthenes");

        }
    };

    public static List<String> getTags() {
        return tags;
    }

    public static void delete(String tag) {
        System.out.println("Tag Deleted: " + tag);
        tags.remove(tag);
    }

    public static void add(String tag) {
        System.out.println("Tag Added: " + tag);
        tags.add(tag);
    }

}
