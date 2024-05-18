package Cour;
public class Stack {
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

    public void insert(int val){
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

    public void DisplayLinkedList() {
        Node current = head;     
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        
    }

    public Node peek(){
        if(head == null){
            return null;
        }else{
            return tail;
        }
    }

    public static void main(String[] args) {
        Stack newstack = new Stack();
        newstack.insert(2);
        newstack.insert(3);
        newstack.insert(4);
        newstack.removeLast();
        newstack.DisplayLinkedList();
    }
}