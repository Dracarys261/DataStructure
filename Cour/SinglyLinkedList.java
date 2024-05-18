package Cour;
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;
    private class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public SinglyLinkedList(int val){
        Node newNode = new Node(val);
        head= newNode;
        tail= newNode;
        length=1;
    }
    public void addFirst(int val) {
        Node newNode = new Node(val);
        if(length==0) {
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        length++;
    }
    public void addEnd(int val){
        Node newNode = new Node(val);
        if(head==null) {
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(head==null) return null;
        Node temp = head;
        head = head.next;
        temp.next=null;
        length--;
        if(length==0) tail=null;
        return temp;
    }

    public Node removeLast(){
        if(head==null) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next!=null){
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        length--;
        if(length==0) {head=null;tail=null;}
        return temp;
    }

    public Node get(int index){
        if(index<0 || index>=length){
            return null;
        }else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp!=null){
            temp.data=value;
            return true;
        }
        return false;
    }
    public boolean insert(int index,int value){
        if(index<0 || index>length) return false;
        if(index==0){
            addFirst(value);
            return true;
        }
        if(index==length){
            addEnd(value);
            return true;
        }
        Node newNode=new Node(value);
        Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next=newNode;
        length++;
        return true;
    }
    public void DisplayLinkedList() {
        Node current = head;
        System.out.print("head ==> ");
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList(1);
        myList.addFirst(2);
        myList.addEnd(3);
        myList.DisplayLinkedList();

        //System.out.println(myList.get(2).data);
        //myList.set(1,4);
        myList.insert(1,7);
        myList.DisplayLinkedList();
        /*
        myList.DisplayLinkedList();
        myList.removeFirst();
        myList.DisplayLinkedList();
        myList.removeLast();
        myList.DisplayLinkedList();
        */
    }
}


