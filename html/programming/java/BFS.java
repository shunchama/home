
import java.util.*;

class BFS {

    private Map<Character, List<Character>> graph = new HashMap<>();

    //Add an edge to the graph
    public void addEdge(char node1, char node2) {
        graph.putIfAbsent(node1, new ArrayList<>());
        graph.putIfAbsent(node2, new ArrayList<>());
        graph.get(node1).add(node2);
        graph.get(node2).add(node1); //Undirected graph
    }

    //BFS Implementation
    public void bfs(char startNode) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        System.out.print("BFS Order: ");

        while (!queue.isEmpty()) {
            char current = queue.poll();
            System.out.print(current + " ");

            for (char neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS graph = new BFS();
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');

        graph.bfs('A');
    }
}
