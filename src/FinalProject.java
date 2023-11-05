import java.util.Random;
import java.util.Scanner;

class Node {
    String key;
    String value;
    Node right;
    Node left;
    Node parent;
    boolean red;

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
    Node root;

    FinalProject() {}

    boolean add(String key, String value) {
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
        if (cmp == 0) {
            return false; 
        } else if (cmp < 0) {
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

    String isExist(String key) {
        //gimiick dari kata random
        if(key.equals("random")) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(random.nextInt(101));
                if (i < 9) {
                    sb.append(", ");
                }
            }
            return sb.toString();
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

    public void gimmick() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nMasukkan perintah (add/cari/exit): ");
            String in = input.nextLine();
            if (in.equals("add")) {
                System.out.print("Masukkan Kata: ");
                String key = input.nextLine();
                System.out.print("Masukkan Terjemahan: ");
                String value = input.nextLine();
                boolean result = add(key, value);
                if (result) {
                    System.out.println("Kata berhasil ditambahkan");
                } else {
                    System.out.println("Kata dan terjemahannya sudah ada");
                }
            } else if (in.equals("cari")) {
                System.out.print("Masukkan kata yang ingin di terjemahkan: ");
                String key = input.nextLine();
                String result = isExist(key);
                if (result != null) {
                    if( key.equals("random") ){
                        System.out.println("Ini adalah angka random = " + result);
                    }else{
                        System.out.println("Terjemahan dari kata " + key + " adalah " + result);
                    }
                } else {
                    System.out.println("Terjemahan dari kata " + key + " tidak ditemukan");
                }
            } else if (in.equals("exit")) {
                break;
            } else {
                System.out.println("Perintah tidak dikenali");
            }
        }
    }

    public static void main(String[]args){
        FinalProject tree = new FinalProject();
        tree.add("random", "acak");
        tree.add("school", "sekolah");
        tree.add("hallo", "halo");
        tree.add("morning", "pagi");
        tree.gimmick();
    }
}// end class
