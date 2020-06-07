package dev.algos.snatch.interview_problems.graph;

/**
 * Detect cycle in undiricted graph
 */
public class HasCycle {

    /**
     * Time O(V + E)
     * Space O(V)
     */
    boolean hasCycle(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i] && hasCycleUtil(graph, -1, i, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(int[][] graph, int parent, int node, boolean[] visited) {
        visited[node] = true;
        for (int adj : graph[node]) {
            if (!visited[adj]) {
                if (hasCycleUtil(graph, node, adj, visited)) {
                    return true;
                }
            } else {
                //works for undirected graph! if visited and adjacent node is not parent
                if (adj != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
