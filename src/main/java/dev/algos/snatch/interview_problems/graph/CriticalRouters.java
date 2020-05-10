package dev.algos.snatch.interview_problems.graph;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an undirected connected graph.
 * An articulation point (or cut vertex) is defined as a vertex which,
 * when removed along with associated edges, makes the graph disconnected (or more precisely,
 * increases the number of connected components in the graph). The task is to find all articulation points in the given graph.
 * <p>
 * Input:
 * The input to the function/method consists of three arguments:
 * <p>
 * numNodes, an integer representing the number of nodes in the graph.
 * numEdges, an integer representing the number of edges in the graph.
 * edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
 * Output:
 * Return a list of integers representing the critical nodes.
 * <p>
 * Example:
 * <p>
 * Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
 */
public class CriticalRouters {

    int time = 0;

    /**
     * Time O(V + E)
     * Space O(V)
     */
    public List<Integer> findAllArticulationPoints(int numNodes, int[][] edges) {
        List[] graph = new List[numNodes];
        for (int i = 0; i < numNodes; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        List<Integer> result = new ArrayList<>();

        int[] discovered = new int[numNodes];
        int[] low = new int[numNodes]; // lowest time of discovered times of neighbors
        int[] parent = new int[numNodes];
        Arrays.fill(parent, -1);
        Arrays.fill(discovered, -1);
        for (int i = 0; i < graph.length; i++) {
            if (discovered[i] == -1) {
                tarjan(parent, i, result, discovered, low, graph);
            }
        }
        return result;
    }

    private void tarjan(int[] parent, int src, List<Integer> result, int[] discovered, int[] low, List[] graph) {
        low[src] = discovered[src] = ++time;
        List<Integer> destinations = graph[src];
        boolean articulation = false;
        int childCount = 0;
        for (var dst : destinations) {
            if (dst == parent[src]) continue;
            //if it wasn't visited - visit it
            if (discovered[dst] == -1) {
                parent[dst] = src;
                childCount++;
                tarjan(parent, dst, result, discovered, low, graph);
                low[src] = Math.min(low[src], low[dst]);
                if (discovered[src] <= low[dst]) { // base condition
                    articulation = true;
                }
            } else {
                // if dst is already visited see if we can go better in time
                low[src] = Math.min(discovered[dst], low[src]);
            }
        }
        if ((parent[src] == -1 && childCount >= 2) || parent[src] != -1 && articulation) {
            result.add(src);
        }
    }
}
