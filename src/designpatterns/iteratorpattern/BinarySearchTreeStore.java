package designpatterns.iteratorpattern;

public class BinarySearchTreeStore implements Iterable {

    private  TreeNode root;

    public BinarySearchTreeStore(TreeNode root) {
        this.root = root;
    }


    @Override
    public Iterator getIterator() {
        return new BinarySearchTreeIterator(this.root);
    }

    public void insert(TreeNode node) {
        TreeNode currentNode = root;
        TreeNode parentNode = null;
        while (null != currentNode) {
            parentNode = currentNode;
            if (node.getFlightNumber() > currentNode.getFlightNumber()) {
                currentNode = currentNode.getRightNode();
            } else {
                currentNode = currentNode.getLeftNode();
            }
        }
        if (node.getFlightNumber() > parentNode.getFlightNumber()) {
            parentNode.setRightNode(node);
        } else {
            parentNode.setLeftNode(node);
        }
    }
}
