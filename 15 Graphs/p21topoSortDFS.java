import java.util.*;

// Class that implements Topological Sort using DFS
class Solution {

    // DFS helper function to visit nodes and push them to the stack after exploring all neighbors
    private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1; // Mark the node as visited

        // Visit all unvisited neighbors (i.e., perform DFS on them)
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }

        // After visiting all neighbors, push current node to the stack (post-order)
        st.push(node); 
    }

    // Function to perform Topological Sort and return the result as an array
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V]; // Visited array to track visited vertices
        Stack<Integer> st = new Stack<>(); // Stack to store the topological order

        // Visit all vertices using DFS
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }

        // Pop elements from stack to get the topological ordering
        int ans[] = new int[V];
        int i = 0;
        while (!st.isEmpty()) {
            ans[i++] = st.pop(); // Store the node and remove from stack
        }
        return ans; // Return the topological order
    }
}

public class p21topoSortDFS {
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the directed edges (from -> to)
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        // Perform topological sort
        int[] ans = Solution.topoSort(V, adj);

        // Print the topological ordering
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
