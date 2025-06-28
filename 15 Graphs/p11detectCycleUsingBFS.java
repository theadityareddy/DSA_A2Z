import java.util.*;

public class p11detectCycleUsingBFS {

    // Function to check if there's a cycle in the undirected graph
    public static boolean isCyclic(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // Check for cycle in each component
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfsCycleCheck(i, visited, adj))
                    return true;
            }
        }

        return false;
    }

    // Helper function to perform BFS and check for cycles
    private static boolean bfsCycleCheck(int start, boolean[] visited, List<List<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>(); // Each element is [node, parent]

        queue.offer(new int[]{start, -1});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    // Visited and not coming from parent → cycle found
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5; // number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Undirected edges
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        // Uncomment below to introduce a cycle:
        // adj.get(4).add(1);
        // adj.get(1).add(4);

        boolean hasCycle = isCyclic(V, adj);
        System.out.println("Cycle detected? " + hasCycle);
    }
}
