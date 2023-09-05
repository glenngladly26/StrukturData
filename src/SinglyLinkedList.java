public class SinglyLinkedList {
    private Node first;
    

    //konstruktor class SinglyLinkedList
    public SinglyLinkedList(){
        this.first = null;
        
    }

    //class Node
    public class Node{
        private int value;
        private Node next;
        
        //konstruktor class node
        public Node(int value){
            this.value = value;
            this.next = null;
        }
        
        //method class Node
        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return next;
        }

        public  int getValue(){
            return value;
        }
    }

    //method class SinglyLinkedList
    public void add(int value){
        //kita membuat node baru
        Node newNode = new Node(value);

        if(first == null){
            first = newNode;
            return;
        }
        Node sem = first;
        while(sem.getNext() != null){
            sem = sem.getNext();
        }
        sem.setNext(newNode);
        
    }
    
    // method insert
    public void insert(int value, int index){
        Node newNode = new Node(value);
        if(index == 0){
            newNode.setNext(first);
            first = newNode;
            return;
        }else{
            Node sem = first;
            int indexSem = 0;

            while(sem != null && indexSem < index - 1){
                sem = sem.getNext();
                indexSem++;
            }
            newNode.setNext(sem.getNext()); 
            sem.setNext(newNode); 
        }
    }

    public void remove(int index){
        if(first == null){
            System.out.println("LinkedList tidak ada");
        }
        if(index == 0){
                first = first.getNext();
        }
        else{  
            Node sem = first;
            Node sem2 = null;
            int indexSem = 0;
            while(sem != null && indexSem != index){
                sem2 = sem;
                sem = sem.getNext();
                indexSem++; //kenapa indexnya harus ditambahim?
            }
            sem2.setNext(sem.getNext()); 
        }
    }

    public void swap(int index1, int index2){
        if (index1 == index2) {
            return; // Tidak perlu dilakukan pertukaran jika indeks sama
        }

        Node sem1 = first, prevSem1 = null;
        int indexSem1 = 0;
        while(sem1 != null && indexSem1 < index1){
            prevSem1 = sem1;
            sem1 = sem1.getNext();
            indexSem1++;
        }
        
        Node sem2 = first, prevSem2 = null;
        int indexSem2 = 0;
        while(sem2 != null && indexSem2 < index2){
            prevSem2 = sem2;
            sem2 = sem2.getNext();
            indexSem2++;
        }

        if(prevSem1 != null){
            prevSem1.setNext(sem2); 
        }else{
            first = sem2;
        }

        if(prevSem2 != null){
            prevSem2.setNext(sem1); 
        }else{
            first = sem1;
        }
        Node sem3 = sem1.getNext();
        sem1.setNext(sem2.getNext()); 
        sem2.setNext(sem3); 
    }

    
    public int get(int index){
        return index;
    }
    
    public void  selectionSortACS(){
        for( Node i = first; i != null; i = i.getNext() ){
            Node minNode = i;

            for( Node j = i.getNext(); j !=null; j = j.getNext()){
                if( minNode.getValue() > j.getValue() ){
                    minNode = j;
                }
            }
            display();
            System.out.println();
            
            int temp = i.getValue();
            i.value = minNode.getValue();
            minNode.value = temp;
        }
    }
    
    public void bubbleSortACS(){
        display();
        for( Node i = first; i != null; i = i.next){
    
            for( Node j = first; j.getNext() !=null ; j = j.next){
                if( j.getValue() > j.getNext().getValue() ){
                    
                    int temp = j.getValue();
                    j.value = j.getNext().getValue();
                    j.next.value = temp;
                    display();
                }
            }
            
        }
    }

    public void display() {
        Node sem = first;
        while (sem != null) {
            System.out.print(sem.value + " " );
            sem = sem.getNext();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(99);
        list.add(76);
        list.add(87);
        list.add(69);
        list.add(80);
        
        
        // list.selectionSortACS();
        list.bubbleSortACS();
        list.display();
    }
}




