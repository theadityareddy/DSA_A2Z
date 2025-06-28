import java.util.*;

class Solution {
    public boolean hasCycle(int V, List<List<Integer>> adj) {
        // visited[i] = true → node i has been visited
        // recStack[i] = true → node i is in the current DFS recursion stack
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        // Check all nodes (for disconnected components)
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true; // cycle detected
                }
            }
        }

        return false; // no cycle found
    }

    // DFS helper function
    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                // Found a node again in the current path → cycle
                return true;
            }
        }

        recStack[node] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        
        // Sample graph with cycle: 0 → 1 → 2 → 0, and 3 → 2
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(3).add(2);

        Solution sol = new Solution();
        System.out.println("Cycle detected? " + sol.hasCycle(V, adj)); // true
    }
}
