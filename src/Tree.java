class Node{
    private int key;
    private Node right;
    private Node left;

    public Node( int key ){
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

public class Tree {
    private Node root;

    public Tree(){
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


    public boolean remove( int key ){
        if( !search(key) ){
            return false;
        }

        root = removeRekursif( root , key);
        return true;
    }
    private Node removeRekursif( Node root, int key ){
        if( root == null ){
            return null;
        }

        if( key < root.getKey() ){
            root.setLeft(removeRekursif(root.getLeft(), key));
        }else if( key > root.getKey() ){
            root.setRight(removeRekursif(root.getRight(), key));
        }else if( key == root.getKey() ){

            
            if( root.getLeft() != null && root.getRight() != null ){
                int temp = maxKey( root.getLeft() );
                root.setKey( temp );
                root.setLeft(removeRekursif(root.getLeft(), temp));
                return root;

            }
            
            else if( root.getLeft() != null ){
                return root.getLeft();
            }else if( root.getRight() != null ){
                return root.getRight();
            }

            else{
                return null;
            }
        }
        return root;
    }

    public int maxKey( Node root ){
        if( root.getRight() != null ){
            return maxKey(root.getRight());
        }else{
            return root.getKey();
        }
    }


    public boolean search( int key ){
        return searchRekursif( root, key );
    }
    private boolean searchRekursif( Node root, int key ){
        if( root == null  ){
            return false;
        }else if( key == root.getKey() ){
            return true;
        }else if( key < root.getKey() ){
            return searchRekursif(root.getLeft(), key);
        }else{
            return searchRekursif(root.getRight(), key);
        }
    }



    public void preOrder( Node root ){
        if( root != null ){
            System.out.print( root.getKey() + " " );
            preOrder( root.getLeft() );
            preOrder( root.getRight() );
        }
    }

    public void inOrder( Node root ){
        if( root != null ){
            inOrder( root.getLeft() );
            System.out.print( root.getKey() + " " );
            inOrder( root.getRight() );
        }
    }

    public void postOrder( Node root ){
        if( root != null ){
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print( root.getKey() + " " );
        }
    }

    public static void main(String[] args){
        Tree tree = new Tree();
        tree.add(8);
        tree.add(3);
        tree.add(10);
        tree.add(1);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(7);
        tree.add(13);

        tree.remove(3);

        System.out.println("== Algoritma Pre-Order ==");
        tree.preOrder( tree.root );
        System.out.println("\n");
        
        System.out.println("== Algoritma In-Order ==");
        tree.inOrder( tree.root );
        System.out.println("\n");
        
        System.out.println("== Algoritma Post-Order ==");
        tree.postOrder( tree.root );
        System.out.println("\n");

    }
}//end class