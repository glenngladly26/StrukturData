class Node{
    private int key;
    private Node right;
    private Node left;
    private Node parent;
    private boolean red;

    public Node( int key ){
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

    public Node getLeft(){
        return left;
    }

    public Node getParent(){
        return parent;
    }

    public int getKey(){
        return key;
    }

    public boolean isRed(){
        return red;
    }
}

public class RedBlackTree {
    private Node root;
    
    public RedBlackTree(){
        
    }

    public boolean add(int key) {
        if( isExist(key) ){
            return false;
        }
    
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
            root.setRed(false);
            return true;
        }
        return addRecursive(root, newNode);
    }
    private boolean addRecursive(Node node, Node newNode) {
        if (newNode.getKey() < node.getKey()) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                newNode.setParent(node);
                newNode.setRed(true);
                balanceAdd(newNode);
                return true;
            } else {
                return addRecursive(node.getLeft(), newNode);
            }
        } else if (newNode.getKey() > node.getKey()) {
            if (node.getRight() == null) {
                node.setRight(newNode);
                newNode.setParent(node);
                newNode.setRed(true);
                balanceAdd(newNode);
                return true;
            } else {
                return addRecursive(node.getRight(), newNode);
            }
        } else {
            return false;
        }
    }

    private void balanceAdd(Node node) {
        while (node != root && node.getParent().isRed()) {
            if (node.getParent() == node.getParent().getParent().getLeft()) {
                Node uncle = node.getParent().getParent().getRight();
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setRed(false);
                    uncle.setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getRight()) {
                        node = node.getParent();
                        rotateToLeft(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rotateToRight(node.getParent().getParent());
                }
            } else {
                Node uncle = node.getParent().getParent().getLeft();
                if (uncle != null && uncle.isRed()) {
                    node.getParent().setRed(false);
                    uncle.setRed(false);
                    node.getParent().getParent().setRed(true);
                    node = node.getParent().getParent();
                } else {
                    if (node == node.getParent().getLeft()) {
                        node = node.getParent();
                        rotateToRight(node);
                    }
                    node.getParent().setRed(false);
                    node.getParent().getParent().setRed(true);
                    rotateToLeft(node.getParent().getParent());
                }
            }
        }
        root.setRed(false);
    }

    public boolean isExist(int key) {
        Node node = root;
        while (node != null) {
            if (key == node.getKey()) {
                return true;
            } else if (key < node.getKey()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return false;
    }

    private void rotateToRight(Node current) {
        Node leftChild = current.getLeft();
        current.setLeft(leftChild.getRight());
        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(current);
        }
        leftChild.setParent(current.getParent());
        if (current.getParent() == null) {
            root = leftChild;
        } else if (current == current.getParent().getLeft()) {
            current.getParent().setLeft(leftChild);
        } else {
            current.getParent().setRight(leftChild);
        }
        leftChild.setRight(current);
        current.setParent(leftChild);
    }
    
    private void rotateToLeft(Node current) {
        Node rightChild = current.getRight();
        current.setRight(rightChild.getLeft());
        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(current);
        }
        rightChild.setParent(current.getParent());
        if (current.getParent() == null) {
            root = rightChild;
        } else if (current == current.getParent().getLeft()) {
            current.getParent().setLeft(rightChild);
        } else {
            current.getParent().setRight(rightChild);
        }
        rightChild.setLeft(current);
        current.setParent(rightChild);
    }

    public void preOrder() {
        preOrderRecursive(root);
    }
    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
    }
    
    public void inOrder() {
        inOrderRecursive(root);
    }
    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderRecursive(node.getRight());
        }
    }
    
    public void postOrder() {
        postOrderRecursive(root);
    }
    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.getLeft());
            postOrderRecursive(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public static void main (String[] args){
        RedBlackTree rbt = new RedBlackTree();
        rbt.add(8);
        rbt.add(3);
        rbt.add(10);
        rbt.add(1);
        rbt.add(6);
        rbt.add(14);
        rbt.add(4);
        rbt.add(7);
        rbt.add(13);
        rbt.add(12);


        System.out.println("== INPUT ==");
        int[] nilai = {8, 3, 10, 1, 6, 14, 4, 7, 13, 12};
        for (int i = 0; i < nilai.length; i++) {
            rbt.add(nilai[i]);
            System.out.print(nilai[i] + " ");
        }
        System.out.println("\n");

        System.out.println("== Algoritma Pre-Order ==");
        rbt.preOrder();
        System.out.println("\n");
        
        System.out.println("== Algoritma In-Order ==");
        rbt.inOrder();
        System.out.println("\n");
        
        System.out.println("== Algoritma Post-Order ==");
        rbt.postOrder();
        System.out.println("\n");
    }

}
