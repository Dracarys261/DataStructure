import java.util.*;

public class Hash {
    private int size = 5;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String k, int val) {
            this.key = k;
            this.value = val;
        }
    }

    public Hash() {
        dataMap = new Node[size];
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 19) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while ((temp.next != null)) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int Search(String k) {
        int index = hash(k);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == k)
                return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void Display() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + "");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("{" + temp.key + ":" + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Hash myHT = new Hash();
        System.out.println(myHT.hash("koto"));
        
        myHT.set("SmartPhone",4000);
        myHT.set("Laptop",4500);
        myHT.set("Tablet",800);
        myHT.set("Printer",8400);
        myHT.set("Tv",8400);
        //System.out.println(myHT);
          
         

    }
}
