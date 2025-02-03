
import java.util.*;

class Graph {

    private Map<Integer, List<Integer>> adjList;

    //Constructor
    public Graph() {
        adjList = new HashMap<>();
    }

    //Add an edgte to the graph
    public void addEdge(int u, int v) {
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    //DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int node, Set<Integer> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjList.get(node)) {
            dfsHelper(neighbor, visited);
        }
    }
}

public class DFS {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);

        graph.dfs(0);
    }
}
