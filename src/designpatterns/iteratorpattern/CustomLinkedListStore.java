package designpatterns.iteratorpattern;

public class CustomLinkedListStore implements Iterable {

    private  CustomLinkedListNode head;

    public CustomLinkedListStore(CustomLinkedListNode head) {
        this.head = head;
    }

    public void insert(CustomLinkedListNode node) {
        CustomLinkedListNode previous = head;
        while (previous.getNextNode() != null)
            previous = previous.getNextNode();
        previous.setNextNode(node);
    }
    public CustomLinkedListNode getHead() {
        return head;
    }

    public void setHead(CustomLinkedListNode head) {
        this.head = head;
    }

    @Override
    public Iterator getIterator() {
        return new CustomLinkedListIterator(this.head);
    }
}
