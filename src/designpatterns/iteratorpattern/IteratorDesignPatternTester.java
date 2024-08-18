package designpatterns.iteratorpattern;

import java.util.ArrayList;
import java.util.List;


//Iterator Design Pattern is a behavourial design Pattern  that provides a way to access elements of a collection
//sequentially without exposing underlying representation/Implementation of collection
public class IteratorDesignPatternTester {
    public static void main(String[] arg){
        TreeNode root=new TreeNode(1,null,null);
        BinarySearchTreeStore binarySearchTreeStore=new BinarySearchTreeStore(root);

        CustomLinkedListNode head=new CustomLinkedListNode(2,null);
        CustomLinkedListStore customLinkedListStore=new CustomLinkedListStore(head);

        MyListStore myListStore=new MyListStore();
        myListStore.insert(3);

        List<Iterable> iterables=new ArrayList<>();
        iterables.add(binarySearchTreeStore);
        iterables.add(customLinkedListStore);
        iterables.add(myListStore);

        for(Iterable iterable:iterables){
            display(iterable);
        }

    }
    private static void display(Iterable iterable){
        Iterator iterator=iterable.getIterator();
        if(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
