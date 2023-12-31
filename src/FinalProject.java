import java.util.Random;

class Node {
    private String key;
    private String value;
    private Node right;
    private Node left;
    private Node parent;
    private boolean red;

    Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    void setRight(Node right) {
        this.right = right;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setParent(Node parent) {
        this.parent = parent;
    }

    void setRed(boolean red) {
        this.red = red;
    }

    Node getRight() {
        return right;
    }

    Node getLeft() {
        return left;
    }

    Node getParent() {
        return parent;
    }

    String getKey() {
        return key;
    }

    String getValue() {
        return value;
    }

    boolean isRed() {
        return red;
    }
}

public class FinalProject {
    private Node root;

    FinalProject() {}

    public boolean add(String key, String value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            root.setRed(false);
            return true;
        } else {
            boolean result = addRekursif(root, newNode);
            root.setRed(false);
            return result;
        }
    }
    private boolean addRekursif(Node node, Node newNode) {
        int cmp = newNode.getKey().compareTo(node.getKey());
        if (cmp == 0) { //jika key sdh ada
            return false; 
        }else if (cmp < 0) {
            if (node.getLeft() == null) {
                node.setLeft(newNode);
                newNode.setParent(node);
                balanceAdd(newNode);
                return true;
            } else {
                return addRekursif(node.getLeft(), newNode);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(newNode);
                newNode.setParent(node);
                balanceAdd(newNode);
                return true;
            } else {
                return addRekursif(node.getRight(), newNode);
            }
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
    private void rotateToRight(Node node) {
        Node leftChild = node.getLeft();
        node.setLeft(leftChild.getRight());
        if (leftChild.getRight() != null) {
            leftChild.getRight().setParent(node);
        }
        leftChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = leftChild;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(leftChild);
        } else {
            node.getParent().setRight(leftChild);
        }
        leftChild.setRight(node);
        node.setParent(leftChild);
    }
    private void rotateToLeft(Node node) {
        Node rightChild = node.getRight();
        node.setRight(rightChild.getLeft());
        if (rightChild.getLeft() != null) {
            rightChild.getLeft().setParent(node);
        }
        rightChild.setParent(node.getParent());
        if (node.getParent() == null) {
            root = rightChild;
        } else if (node == node.getParent().getLeft()) {
            node.getParent().setLeft(rightChild);
        } else {
            node.getParent().setRight(rightChild);
        }
        rightChild.setLeft(node);
        node.setParent(rightChild);
    }

    public String isExist(String key) {
        if(key.equals("random")) {
            return gimmick("random");
        }else{
            Node current = root;
            while (current != null) {
                int cmp = key.compareTo(current.getKey());
                if (cmp == 0) {
                    return current.getValue();
                } else if (cmp < 0) {
                    current = current.getLeft();
                } else {
                    current = current.getRight();
                }
            }
            return null;
        }
    }
    
    public String gimmick( String key){
        if( key.equals("random") ){
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(random.nextInt(101));
                if (i < 9) {
                    sb.append(", ");
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static void main(String[]args){
        FinalProject tree = new FinalProject();
        tree.add("random", "acak");
        tree.add("school", "sekolah");
        tree.add("hallo", "halo");
        tree.add("morning", "pagi");
        tree.add("break", "berhenti sejenak");
        tree.add("breakfast", "sarapan");
        tree.add("close", "tutup");
        tree.add("picture", "foto");
        tree.add("full", "penuh");
        
    }
}// end class
