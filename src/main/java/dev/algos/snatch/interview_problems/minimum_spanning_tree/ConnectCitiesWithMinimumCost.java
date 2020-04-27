package dev.algos.snatch.interview_problems.minimum_spanning_tree;

import java.util.Arrays;

/**
 * There are N cities numbered from 1 to N.
 * <p>
 * You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)
 * <p>
 * Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 * Output: 6
 * Explanation:
 * Choosing any 2 edges will connect all cities so we choose the minimum 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: N = 4, connections = [[1,2,3],[3,4,4]]
 * Output: -1
 * Explanation:
 * There is no way to connect all cities even if all edges are used.
 */
public class ConnectCitiesWithMinimumCost {

    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(N);
        int total = 0;
        for (int[] edge : connections) {
            if (uf.union(edge[0], edge[1])) {
                total += edge[2];
            }
        }
        return uf.n == 1 ? total : -1;
    }

    static class UnionFind {
        int[] arr;
        int n; // - number of roots

        public UnionFind(int n) {
            this.arr = new int[n + 1];
            this.n = n;
            for (int i = 0; i <= n; i++) {
                arr[i] = i;
            }
        }

        int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        boolean union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (p == q) return false;
            arr[p] = q;
            n--;
            return true;
        }
    }
}
