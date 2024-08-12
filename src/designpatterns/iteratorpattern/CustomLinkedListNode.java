package designpatterns.iteratorpattern;

public class CustomLinkedListNode {

    private final int flightNumber;
    private CustomLinkedListNode nextNode;

    public CustomLinkedListNode(int flightNumber, CustomLinkedListNode nextNode) {
        this.flightNumber = flightNumber;
        this.nextNode = nextNode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public CustomLinkedListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(CustomLinkedListNode nextNode) {
        this.nextNode = nextNode;
    }
}
