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
    private boolean addRekursif(Node current, Node newNode) {
        int cmp = newNode.getKey().compareTo(current.getKey());
        if (cmp == 0) {
            return false; 
        } else if (cmp < 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                newNode.setParent(current);
                fixInsert(newNode);
                return true;
            } else {
                return addRekursif(current.getLeft(), newNode);
            }
        } else {
            if (current.getRight() == null) {
                current.setRight(newNode);
                newNode.setParent(current);
                fixInsert(newNode);
                return true;
            } else {
                return addRekursif(current.getRight(), newNode);
            }
        }
    }
    private void fixInsert(Node current) {
        while (current != root && current.getParent().isRed()) {
            if (current.getParent() == current.getParent().getParent().getLeft()) {
                Node uncle = current.getParent().getParent().getRight();
                if (uncle != null && uncle.isRed()) {
                    current.getParent().setRed(false);
                    uncle.setRed(false);
                    current.getParent().getParent().setRed(true);
                    current = current.getParent().getParent();
                } else {
                    if (current == current.getParent().getRight()) {
                        current = current.getParent();
                        rotateToLeft(current);
                    }
                    current.getParent().setRed(false);
                    current.getParent().getParent().setRed(true);
                    rotateToRight(current.getParent().getParent());
                }
            } else {
                Node uncle = current.getParent().getParent().getLeft();
                if (uncle != null && uncle.isRed()) {
                    current.getParent().setRed(false);
                    uncle.setRed(false);
                    current.getParent().getParent().setRed(true);
                    current = current.getParent().getParent();
                } else {
                    if (current == current.getParent().getLeft()) {
                        current = current.getParent();
                        rotateToRight(current);
                    }
                    current.getParent().setRed(false);
                    current.getParent().getParent().setRed(true);
                    rotateToLeft(current.getParent().getParent());
                }
            }
        }
        root.setRed(false);
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

    String isExist(String key) {
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

    void run() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("\nMasukkan perintah (add/cari/exit): ");
            String command = input.nextLine();
            if (command.equals("add")) {
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
            } else if (command.equals("cari")) {
                System.out.print("Masukkan kata yang ingin di terjamahkan: ");
                String key = input.nextLine();
                String result = isExist(key);
                if (result != null) {
                    System.out.println("Terjemahan dari kata " + key + " adalah " + result);
                } else {
                    System.out.println("Terjemahan dari kata " + key + " tidak ditemukan");
                }
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Perintah tidak dikenali");
            }
        }
    }

    public static void main(String[]args){
        FinalProject tree = new FinalProject();
        tree.run();
    }
}// end class
