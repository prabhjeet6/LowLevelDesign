package designpatterns.iteratorpattern;

public class CustomLinkedListIterator implements Iterator {
    CustomLinkedListNode head;
    public CustomLinkedListIterator(CustomLinkedListNode head) {
        this.head=head;
    }

    @Override
    public boolean hasNext() {
        return null!=head;
    }

    @Override
    public int next() {
        int curr = this.head.getFlightNumber();
        head = head.getNextNode();
        return curr;
    }
}
