import java.util.*;

class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    void Addver(String vertex) {

        adjList.put(vertex, new ArrayList<>());
    }

    void AddEdge(String key, String value) {
        adjList.get(key).add(value);

    }

    public void PrintGraph() {
        for (String key : adjList.keySet()) {
            System.out.println(key);
            System.out.println(adjList.get(key));
        }
    }
}

public class graphImplementation {
    public static void main(String[] args) {
        Graph adjGraph = new Graph();
        adjGraph.Addver("A");
        adjGraph.Addver("B");
        adjGraph.Addver("C");
        adjGraph.Addver("E");
        adjGraph.AddEdge("A", "B");
        adjGraph.AddEdge("A", "C");
        adjGraph.AddEdge("A", "E");
        adjGraph.PrintGraph();
    }
}