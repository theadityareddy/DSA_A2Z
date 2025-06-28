class p19bipartiteDFS {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0: unvisited, 1: color1, -1: color2

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                // Start DFS with color1 (1)
                if (!dfs(graph, i, 1, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    // Recursive DFS to color the graph
    private boolean dfs(int[][] graph, int node, int currentColor, int[] color) {
        color[node] = currentColor;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == 0) {
                // If neighbor is unvisited, recursively color with opposite color
                if (!dfs(graph, neighbor, -currentColor, color)) {
                    return false;
                }
            } else if (color[neighbor] == currentColor) {
                // If neighbor already has the same color → not bipartite
                return false;
            }
        }

        return true;
    }
}
