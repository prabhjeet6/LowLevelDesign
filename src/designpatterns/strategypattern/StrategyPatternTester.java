package designpatterns.strategypattern;

public class StrategyPatternTester {
    public static void main(String[] asd){
        //BinarySearcher shouldn't be used with UnOrderedInserter, as it is prerequisite
        // for a List to be sorted inorder for the binary search to be applied on it.
        //Hence, Possible Combinations are
        //1. UnOrderedInserter LinearSearcher
        //2. OrderedInserter   BinarySearcher
        NumStore numStore=new NumStore(new UnOrderedInserter(),new LinearSearcher());

        numStore.insert(3);
        numStore.insert(2);
        numStore.insert(1);

        System.out.println(numStore.search(3));
        System.out.println(numStore.search(10));

        System.out.println(numStore.search(2));
        System.out.println(numStore.search(100));



    }

}
