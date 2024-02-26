
package DataStructure;


public class LinkedList {
    Node head,tail;
    public LinkedList(){
        head=tail=null;
    }
    //access methods
    public boolean isEmpty(){
        return head==null;
    }
    private int size=0;
    public int size() {
        return size;
    }
    public Node first(){
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }
    
    public Node last(){
        return tail;
    }
    //update methods
    public void addLast(Object infor){
        Node p=new Node(infor,null);
        if (isEmpty()){
            head=tail= new Node(infor);
        } else {
            tail.next=p;
            tail=p;            
        }
        size++;
    }
    public void addFirst(Object infor){
        if (isEmpty()){
            head=tail= new Node(infor);
        } else { 
            head=new Node(infor,head);    
        }
        size++;
    }
    public void addK(Object infor, int k) {

        if (k >= 0 && k < size()) {
            Node current = first();
            for (int i = 0; i < k && current != null; i++) {
                current=current.next;
            }
            Node newN,nextNode=current.next;
            newN = new Node(infor, nextNode);
            current.next=newN;
            size++;
        }

    }
    public void removeK(int k) {
        if (isEmpty()) return;
        else if (k >= 0 && k < size()) {
            Node preNode=new Node();
            Node current = first();
            for (int i = 0; i < k && current != null; i++) {
                preNode=current;
                current=current.next;
            }
            Node nextNode=current.next;
            preNode.next=nextNode;
            if (k==0) head=nextNode;
            size--;
        }

    }
    

    public void traverse(){
        Node p=head;
        while (p!=null){
            System.out.println( p.infor + " ");
            p=p.next;
        }
        System.out.println();
    }
    public void removeFirst(){
        if (isEmpty()){
            return;
        } else {
            head=head.next;
        }
        size--;
        if (size==0) tail=null;
    }
}
