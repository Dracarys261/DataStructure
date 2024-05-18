package Cour;
public class Stack2 {
    private Node head;
    private Node tail;
    private int length;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node pop() {
        if (head == null) {
            return null; 
        }

        Node current = head;
        Node pre = null;

        while (current.next != null) {
            pre = current;
            current = current.next;
        }

        if (pre == null) {
            head = null;
            tail = null;
        } else {
            pre.next = null;
            tail = pre;
        }

        length--;

        return current;
    }

    public void displayStack() {
        Node current = head;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Node peek() {
        if (tail == null) {
            return null; 
        } else {
            return tail;
        }
    }

    public static void main(String[] args) {
        Stack2 newStack = new Stack2();
        newStack.insert(2);
        newStack.insert(3);
        newStack.insert(4);
        newStack.displayStack(); 
        newStack.pop();
        newStack.displayStack();

        Node topNode = newStack.peek();
        if (topNode != null) {
            System.out.println("Top element of the stack: " + topNode.data); // Affiche : Top element of the stack: 3
        } else {
            System.out.println("Stack is empty.");
        }
    }
}
