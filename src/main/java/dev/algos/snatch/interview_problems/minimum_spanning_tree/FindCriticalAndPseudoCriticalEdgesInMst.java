package dev.algos.snatch.interview_problems.minimum_spanning_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Given a weighted undirected connected graph with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi, weighti] represents a bidirectional and weighted edge between nodes fromi and toi. A minimum spanning tree (MST) is a subset of the edges of the graph that connects all vertices without cycles and with the minimum possible total edge weight.
 * <p>
 * Find all the critical and pseudo-critical edges in the minimum spanning tree (MST) of the given graph. An MST edge whose deletion from the graph would cause the MST weight to increase is called a critical edge. A pseudo-critical edge, on the other hand, is that which can appear in some MSTs but not all.
 * <p>
 * Note that you can return the indices of the edges in any order.
 */
public class FindCriticalAndPseudoCriticalEdgesInMst {

    /**
     * Time O(E + E^2logE)
     * Space O(E)
     */
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            map.put(edges[i], i);
        }
        Arrays.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        int minCost = buildMst(edges, null, null, n);
        for (int[] edge : edges) {
            int i = map.get(edge);
            int costWithoutEdge = buildMst(edges, edge, null, n);
            // if when we skip we increase cost -> critical
            if (minCost < costWithoutEdge) {
                critical.add(i);
            } else {
                int costWithEdge = buildMst(edges, null, edge, n);
                // if weight is the same with the node it's pseudo
                if (costWithEdge == minCost) {
                    pseudo.add(i);
                }
            }
        }
        return List.of(critical, pseudo);
    }

    private int buildMst(int[][] edges, int[] skip, int[] pick, int n) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;
        if (pick != null) {
            uf.union(pick[0], pick[1]);
            cost += pick[2];
        }
        for (int[] edge : edges) {
            if (skip != edge && uf.union(edge[0], edge[1])) {
                cost += edge[2];
            }
        }
        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }

    static class UnionFind {
        int[] arr;
        int[] size;
        int count;

        public UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
            count = n;
        }

        private int root(int i) {
            while (arr[i] != i) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        private boolean union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (arr[p] == arr[q]) return false;
            if (size[p] > size[q]) {
                arr[p] = arr[q];
                size[q] += size[p];
            } else {
                arr[q] = arr[p];
                size[p] += size[q];
            }
            count--;
            return true;
        }
    }
}
