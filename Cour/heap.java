import java.util.ArrayList;
import java.util.List;

public class heap {
    private List<Integer> heap;

    public heap() {
        heap = new ArrayList<>();
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    private int leftChilde(int index) {
        return 2 * index + 1;
    }

    private int rightChilde(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    public void insert(int value) {
        heap.add(value);

        int current = heap.size() - 1;
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    private int Hash(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i);
        }
        return res % 3;
    }

    /*
     * private int Hash2(String s){
     * int res = 0;
     * for(int i=0;i<s.length();i++){
     * res += s.charAt(i);
     * }
     * int cry = (4*1/(1+exp(res)));
     * return cry;
     * }
     */

    public static void main(String[] args) {
        heap heap = new heap();
        heap.insert(90);
        heap.insert(70);
        heap.insert(60);
        heap.insert(50);
        System.out.println(heap.getHeap());
        heap.insert(99);
        System.out.println(heap.getHeap());
        System.out.println(
                heap.Hash("JAVASCRIPT"));

    }

}