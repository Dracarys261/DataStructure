import javax.sql.rowset.spi.SyncFactory;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();
    public void addVertex(String key) {
        adjList.put(key, new ArrayList<>());
    }
    public void addEdge(String key1, String key2) {
        adjList.get(key1).add(key2);
    }
    public static void main(String[] args){
        Graph g = new Graph();
        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        System.out.println(g.adjList);
        g.addEdge("A","B");
        g.addEdge("B","A");
        g.addEdge("B","C");
        System.out.println(g.adjList);
    }
}