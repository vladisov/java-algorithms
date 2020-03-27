package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any other server directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * Example 1:
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */
public class CriticalConnectionsNetwork {

    int time = 0; // time when discover each vertex

    /**
     * Tarjan algorithm
     * Time O(V + E)
     * Space O(V)
     */
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> conn : connections) {
            int src = conn.get(0);
            int dest = conn.get(1);
            graph[src].add(dest);
            graph[dest].add(src);
        }

        int[] low = new int[n];
        int[] disc = new int[n];
        Arrays.fill(disc, -1);
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(graph, i, -1, bridges, disc, low);
            }
        }
        return bridges;
    }

    private void dfs(List<Integer>[] graph, int src, int prev,
                     List<List<Integer>> bridges, int[] disc, int[] low) {
        low[src] = disc[src] = ++time;
        for (int dst : graph[src]) {
            if (prev == dst) continue;
            if (disc[dst] == -1) {
                dfs(graph, dst, src, bridges, disc, low);
                low[src] = Math.min(low[src], low[dst]);
                if (low[dst] > disc[src]) {
                    //critical path found
                    bridges.add(List.of(src, dst));
                }
            } else {
                // if dst discovered and is not parent of src, update low[src], cannot use low[dst] because u is not subtree of dst
                low[src] = Math.min(low[src], disc[dst]);
            }
        }
    }
}
