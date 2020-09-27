package dev.algos.snatch.interview_problems.topological_sort;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_II {

    /**
     * Time O(V + E)
     * Space (V)
     */
    public int[] findOrderDFS(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int[] edge : edges) {
            int src = edge[0], dst = edge[1];
            if (graph[src] == null) {
                graph[src] = new ArrayList<>();
            }
            graph[src].add(dst);
        }
        boolean[] visited = new boolean[n];
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (!sort(graph, i, visited, order, new boolean[n])) {
                    return new int[0];
                }
            }
        }

        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean sort(List<Integer>[] graph, int node, boolean[] visited, List<Integer> order, boolean[] visiting) {
        if (visiting[node]) {
            return false;
        }
        visiting[node] = true;
        if (graph[node] != null) {
            for (int adj : graph[node]) {
                if (!visited[adj]) {
                    if (!sort(graph, adj, visited, order, visiting)) {
                        return false;
                    }
                }
            }
        }
        visiting[node] = false;
        visited[node] = true;
        order.add(node);
        return true;
    }
}
