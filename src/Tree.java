class Node{
    private int key;
    private Node right;
    private Node left;

    Node( int key, Node right, Node left ){
        this.key = key;
        this.right = null;
        this.left = null;
    }

    public void setRight( Node right ){
        this.right = right;
    }

    public void setLeft( Node left ){
        this.left = left;
    }

    public int getKey(){
        return key;
    }

    public Node getRight(){
        return right;
    }

    public Node getLeft(){
        return left;
    }
}

public class Tree {
    private Node root;

    Tree( Node root ){
        this.root = root;
    }

    public boolean add( int key ){
        
    }

    public boolean remove( int key ){
        
    }
}