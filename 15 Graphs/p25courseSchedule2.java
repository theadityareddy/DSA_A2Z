import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        // Initialize graph
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        // Build graph and in-degree array
        for (int[] pre : prerequisites) {
            int dest = pre[0], src = pre[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        // Topological order result
        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        // If not all courses were processed, there's a cycle
        return index == numCourses ? order : new int[0];
    }
}
