class Node{
    private int key;
    private Node right;
    private Node left;

    Node(int key){
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

    public void setKey( int key ){
        this.key = key;
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


public class BST {
    Node root;

    public BST(){
        this.root = null;
    }

    public boolean add( int key ){
        if( search(key) ){
            return false;
        }
        root = addRekursif( root, key );
        return true;
    }
    private  Node addRekursif( Node root, int key ){
        if( root == null ){
            root = new Node( key );
            return root;
        }
        if( key < root.getKey() ){
            root.setLeft( addRekursif(root.getLeft(), key));
        }else{
            root.setRight( addRekursif(root.getRight(), key));
        }
        return root;
    }

}
