package designpatterns.iteratorpattern;


public class TreeNode {
     final private int flightNumber;
     private TreeNode leftNode;
     private TreeNode rightNode;

    public TreeNode(int flightNumber, TreeNode leftNode, TreeNode rightNode) {
        this.flightNumber = flightNumber;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
}
