import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency list to represent the graph
        List<List<Integer>> graph = new ArrayList<>();
        // indegree[i] = number of prerequisites for course i
        int[] indegree = new int[numCourses];

        // Initialize graph: create an empty list for each course
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and indegree array from prerequisites
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            // Add edge from prereq to course
            graph.get(prereq).add(course);
            // Increase indegree of the course
            indegree[course]++;
        }

        // Queue for courses with no prerequisites (indegree 0)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i); // Course can be taken immediately
            }
        }

        // Count of courses that can be completed
        int count = 0;

        // Perform BFS (Kahn's Algorithm)
        while (!queue.isEmpty()) {
            int v = queue.poll();
            count++; // This course can be completed

            // Visit all courses dependent on course v
            for (int neighbor : graph.get(v)) {
                indegree[neighbor]--; // One prerequisite satisfied
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor); // Ready to take this course
                }
            }
        }

        // If all courses are completed, return true
        return count == numCourses;
    }
}
