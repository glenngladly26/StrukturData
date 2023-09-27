import java.util.Random;

class Node{
    int value;
    Node next;
    Node prev;

    public Node( int value ){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public  void setNext( Node next ){
        this.next = next;
    }

    public void setPrev( Node prev ){
        this.prev = prev;
    }

    public void setValue( int value ){
        this.value = value;
    }

    public Node getNext(){
        return next;
    }

    public Node getPrev(){
        return prev;
    }

    public int getValue(){
        return value;
    }
}


public class LinkedList {
    private Node first;
    

    public LinkedList(){
        this.first = null;
        
    }

    public void add( int value ){
        Node newNode = new Node( value );
        if( first == null ){
            first = newNode;
            
        }else{
            Node temp = first;
            while( temp.getNext() != null ){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            
        }
    }

    public void bubbleSort(){
        for( Node i = first; i != null; i = i.next){
    
            for( Node j = first; j.getNext() !=null ; j = j.next){
                if( j.getValue() > j.getNext().getValue() ){
                    
                    int temp = j.getValue();
                    j.value = j.getNext().getValue();
                    j.next.value = temp;
                }
            }
            
        }
    }

    public void seletionSort(){
        for( Node i = first; i != null; i = i.getNext() ){
            Node minValue = i;

            for ( Node j = i; j != null; j = j.getNext() ){
                if( minValue.getValue() > j.getValue()  ){
                    minValue = j;
                }
            }
            int temp = i.getValue();
            i.value = minValue.getValue(); 
            minValue.value = temp;
        }
    }

    //method menghitung panjang linkedlist
    public int length(){
        int length = 0;
        Node temp = first;

        while( temp != null ){
            length++;
            temp = temp.getNext();
        }

        return length;
    }

    public void mergerSort(){
        if( length() > 1 ){
            //membuat linkedlist kiri dan kanan
            int nilaiTengah = length() / 2;
            LinkedList kiri = new LinkedList();
            LinkedList kanan = new LinkedList();

            Node temp = first;
            for( int i = 0; i < nilaiTengah; i++ ){
                kiri.add(temp.getValue());
                temp = temp.getNext();
            }

            while( temp != null ){
                kanan.add(temp.getValue());
                temp = temp.getNext();
            }

            kiri.mergerSort();
            kanan.mergerSort();
            merge( kiri, kanan );
        }
    }
    //method menggabungkan linkedlist
    public void merge( LinkedList kiri, LinkedList kanan ){
        Node tempKiri = kiri.first , tempKanan = kanan.first, temp = first;

        while( tempKiri != null && tempKanan != null ){
            if( tempKiri.getValue() <= tempKanan.getValue() ){
                temp.setValue(tempKiri.getValue());
                tempKiri = tempKiri.getNext();
            }else{
                temp.setValue(tempKanan.getValue());
                tempKanan = tempKanan.getNext();
            }
            temp = temp.getNext();
        }

        while( tempKiri != null ){
            temp.setValue(tempKiri.getValue());
            tempKiri = tempKiri.getNext();
            temp = temp.getNext();
        }
        while( tempKanan != null ){
            temp.setValue(tempKanan.getValue());
            tempKanan = tempKanan.getNext();
            temp = temp.getNext();
        }
    }

    public void display(){
        Node sem = first;
        while (sem != null) {
            System.out.print(sem.value + " -->" );
            sem = sem.getNext();
        }
        System.out.println();
    }


    public static void main( String[] args ){
        LinkedList ll = new LinkedList();
        
        Random rand = new Random(0);
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(10);
            ll.add(randomNumber);
        }
        


        System.out.println("==SEBELUM==");
        ll.display();
        
        // ll.bubbleSort();
        // ll.seletionSort();
        ll.mergerSort();
        
        System.out.println("==SESUDAH==");
        ll.display();
    }
}
    



