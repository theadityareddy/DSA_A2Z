import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        // Step 1: Initialize graph and indegree map
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        // Initialize graph with all unique characters
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        // Step 2: Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // Edge case: word2 is a prefix of word1 (invalid)
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break; // Only first different char defines ordering
                }
            }
        }

        // Step 3: Topological Sort (Kahn's Algorithm)
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);
            
            for (char neighbor : graph.get(curr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all characters are in the result, there's a cycle
        return result.length() == indegree.size() ? result.toString() : "";
    }
}
