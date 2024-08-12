package designpatterns.iteratorpattern;

import java.util.Stack;

public class BinarySearchTreeIterator implements Iterator {
    private final TreeNode root;
    private final Stack<TreeNode> nodes;

    public BinarySearchTreeIterator(TreeNode root) {
        this.root = root;
        this.nodes=new Stack<>();
        init();
    }
    private void init(){
        traverse(nodes,root);
    }
    private void traverse(Stack<TreeNode> nodes,TreeNode node){
        if(node==null){
            return;
        }
        nodes.push(node);
        traverse(nodes,node.getLeftNode());
        traverse(nodes,node.getRightNode());
    }
    @Override
    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    @Override
    public int next() {
        TreeNode topNode=nodes.peek();
        if(null!= topNode){
            return topNode.getFlightNumber();
        }else{
            return -1;
        }
    }
}
