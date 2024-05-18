package Cour;
public class Queue {
    private int[] tab;
    private int front; 
    private int rear;  
    private int size;  

    public Queue() {
        this.tab = new int[10];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    
    public void enqueue(int element) {
        rear = (rear + 1) % tab.length;
        tab[rear] = element;
        size++;
    }
    public int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        
        int removedElement = tab[front];
        front = (front + 1) % tab.length;
        size--;
        return removedElement;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue: ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(tab[index] + " ");
            index = (index + 1) % tab.length;
            count++;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        Queue queue = new Queue();

        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); 

        
        int removedElement = queue.dequeue();
        System.out.println("Removed Element: " + removedElement);
        queue.display(); 
    }
}

