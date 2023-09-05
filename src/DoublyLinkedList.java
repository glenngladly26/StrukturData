public class DoublyLinkedList{
    private Node first;
    private Node last;
    
    //Konstruktor class LinkedList
    public DoublyLinkedList(){
        this.first = null;
        this.last = null;
    }
    public class Node{
        private int value;
        private Node next; 
        private Node prev;
        
        // konstruktor
        public Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
        
        // method Node
        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        public  Node getNext(){
            return next;
        }

        public Node getPrev(){
            return prev;
        }

        public int getvalue(){
            return value;
        }
    }

    //method class DoublyLinkedList
    public void add(int value){
        Node newNode = new Node(value);
        if(first == null){
            first = newNode;
            last = first;
            return;
        }else{
            Node sem = first;
            while(sem.next != null){
                sem = sem.next;
            }
            sem.next = newNode;
            newNode.prev = sem;
            last = newNode;
        }
    }

    public void insert(int value, int index){
        if(index < 0){
            System.out.println("index tidak ada");
            return;
        }
        Node newNode = new Node(value);
        Node sem = first;
        if(index == 0){
            newNode.next = sem;
            sem.prev = newNode;
            first = newNode;
            newNode.prev = null;
        }else{
            int indexSem = 0;
            while(sem != null && indexSem < index -1){
                sem = sem.next;
                indexSem++;
            }
            newNode.next = sem.next;
            newNode.prev = sem.next.prev;
            sem.next.prev = newNode;
            sem.next = newNode;
        }
    }

    public void remove(int index){
        if(first == null){
            System.out.println("LinkedList tidak ada");
        }
        if(index == 0){
            first = first.next;
            first.prev = null;
        }
        if(last.next == null){
            Node sem = last;
            sem = sem.prev;
            last = sem;
            last.next = null;
        }else{
            Node sem = first;
            int indexSem = 0;
            while(sem != null && indexSem < index - 1){
                sem = sem.next;
                indexSem++;
            }
            sem.next = sem.next.next;
            sem = sem.next;
            sem.prev = sem.prev.prev;
        }
    }

    public void swap(int index1, int index2){
        if(index1 == index2){
            return;
        }

        Node sem1 = first, sem2 = null, sem3 = first, sem4= null;
        int indexSem1 = 0, indexSem2 = 0;
        while(sem1 != null && indexSem1 < index1){
            sem1 = sem1.next;
            indexSem1++;
        }

        while(sem3 != null && indexSem2 < index2){
            sem3 = sem3.next;
            indexSem2++;
        }
        sem2 = sem1.prev;
        sem4 = sem1.next;
        sem1.prev = sem3.prev;
        sem1.next = sem3.next;
        sem3.prev = sem2;
        sem3.next = sem4;

        // Memperbarui node sebelum dan sesudah node yang ditukar
        if (sem1.prev != null) {
            sem1.prev.next = sem1;
        } else {
            first = sem1;
        }
        if (sem1.next != null) {
            sem1.next.prev = sem1;
        }

        if (sem3.prev != null) {
            sem3.prev.next = sem3;
        } else {
            first = sem3;
        }
        if (sem3.next != null) {
            sem3.next.prev = sem3;
        }
    }

    // masih kurang
    public void insertionSortACS(){
        for( Node i = first.getNext(); i != null ; i = i.getNext() ){

            for( Node j = i; j.getPrev() != null; j = j.getPrev() ){
                    Node sem = j;
                    displayFirst();

                    if( sem.getvalue() < sem.getPrev().getvalue() ){

                        int temp = sem.getvalue();
                        sem.value = sem.getPrev().getvalue();
                        sem.prev.value = temp;
                    }
            }
        }
    }

    public void displayFirst(){
        System.out.println("-----Output Dari Depan-----");
        Node sem = first;
        while(sem != null){
            System.out.print(sem.value +" " + "---> ");
            sem = sem.next;
        }
        System.out.println();
        System.out.println();
    }

    public void displayLast(){
        System.out.println("-----Output Dari Belakang-----");
        Node sem = last;
        while(sem.prev != null){
            System.out.print(sem.value + " " + "---> ");
            sem = sem.prev;
        }
        System.out.print(sem.value + " " + "---> ");
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
            list.add(90);
            list.add(54);
            list.add(67);
            list.add(98);
            list.add(76);

            list.insertionSortACS();
            list.displayFirst();

            // list.displayLast();

    }
}
