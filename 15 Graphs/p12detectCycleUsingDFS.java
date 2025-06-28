import java.util.*;

public class p12detectCycleUsingDFS {

    // Main function to detect cycle in the undirected graph
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Check all components of the graph
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycleCheck(i, -1, visited, adj))
                    return true;
            }
        }
        return false;
    }

    // DFS helper function
    private static boolean dfsCycleCheck(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                // Recurse for unvisited neighbors, if they return true then cycle exists
                if (dfsCycleCheck(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If visited and not coming from parent, cycle detected
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Add undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        // Uncomment below to introduce a cycle
        // adj.get(4).add(1);
        // adj.get(1).add(4);

        boolean hasCycle = isCyclic(V, adj);
        System.out.println("Cycle detected? " + hasCycle);
    }
}
