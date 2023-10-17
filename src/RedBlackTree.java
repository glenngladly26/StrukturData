class Node{
    private char key;
    private Node right;
    private Node left;
    private Node parent;
    private boolean red;

    public Node( char key ){
        this.key = key;
        this.right = null;
        this.left = null;
        this.parent = null;
    }

    public void setRight( Node right ){
        this.right = right;
    }

    public void setLeft( Node left ){
        this.left = left;
    }

    public void setParent( Node parent ){
        this.parent = parent;
    }

    public void setRed( boolean red ){
        this.red = red;
    }

    public Node getRight(){
        return right;
    }

    public Node getLft(){
        return left;
    }

    public Node getParent(){
        return parent;
    }

    public char getKey(){
        return key;
    }

    public boolean isRed(){
        return red;
    }
}

public class RedBlackTree {
    private Node root;
    
    public RedBlackTree(){
        this.root = null;
    }
}
