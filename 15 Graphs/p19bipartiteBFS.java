import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        // color[i] = 0 → unvisited, 1 → color1, -1 → color2
        int[] color = new int[n];

        // Loop through all nodes in case the graph is disconnected
        for (int i = 0; i < n; i++) {
            // If the node hasn't been colored yet
            if (color[i] == 0) {
                // Start BFS from this node
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1; // Assign color1 to starting node

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    // Visit all adjacent (neighbor) nodes
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == 0) {
                            // If neighbor hasn't been colored, assign opposite color
                            color[neighbor] = -color[node];
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            // If neighbor has the same color → not bipartite
                            return false;
                        }
                    }
                }
            }
        }

        // If all nodes are properly colored without conflict, graph is bipartite
        return true;
    }
}
