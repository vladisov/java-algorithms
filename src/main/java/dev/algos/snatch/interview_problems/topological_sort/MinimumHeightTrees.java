package dev.algos.snatch.interview_problems.topological_sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees {

    public static List<Integer> findTrees(int nodes, int[][] edges) {
        List<Integer> minHeightTrees = new ArrayList<>();
        if (nodes <= 0)
            return minHeightTrees;

        // with only one node, since its in-degree will be 0, therefore, we need to handle it separately
        if (nodes == 1) {
            minHeightTrees.add(0);
            return minHeightTrees;
        }

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < nodes; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }

        // b. Build the graph
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0], n2 = edges[i][1];
            // since this is an undirected graph, therefore, add a link for both the nodes
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
            // increment the in-degrees of both the nodes
            inDegree.put(n1, inDegree.get(n1) + 1);
            inDegree.put(n2, inDegree.get(n2) + 1);
        }

        // c. Find all leaves i.e., all nodes with only 1 in-degree
        Queue<Integer> leaves = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 1)
                leaves.add(entry.getKey());
        }

        // d. Remove leaves level by level and subtract each leave's children's in-degrees.
        // Repeat this until we are left with 1 or 2 nodes, which will be our answer.
        // Any node that has already been a leaf cannot be the root of a minimum height tree, because
        // its adjacent non-leaf node will always be a better candidate.
        int totalNodes = nodes;
        while (totalNodes > 2) {
            int leavesSize = leaves.size();
            totalNodes -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int vertex = leaves.poll();
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 1) // if the child has become a leaf
                        leaves.add(child);
                }
            }
        }

        minHeightTrees.addAll(leaves);
        return minHeightTrees;
    }

    /**
     * Time O(V + E)
     * Space O(V + E)
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) {
            return List.of();
        } else if (n == 1) {
            return List.of(0);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            inDegree.put(edge[0], inDegree.get(edge[0]) + 1);
            inDegree.put(edge[1], inDegree.get(edge[1]) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int vertex : graph.keySet()) {
            if (graph.get(vertex).size() == 1) {
                queue.add(vertex);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (graph.size() <= 2) {
                return new ArrayList<>(graph.keySet());
            }
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                for (int nei : graph.get(node)) {
                    inDegree.put(nei, inDegree.get(nei) - 1);
                    if (inDegree.get(nei) == 1) {
                        queue.add(nei);
                    }
                    graph.get(nei).remove(node);
                }
                graph.remove(node);
            }
        }
        return result;
    }
}
