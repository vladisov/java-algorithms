package dev.algos.snatch.interview_problems.union_find;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/checking-existence-of-edge-length-limited-paths/
 */
public class DistanceLimitedPathExists {

    /**
     * Time O(ElogE + QlogQ)
     */
    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] queriesList) {
        int[][] queries = new int[queriesList.length][4];
        for (int i = 0; i < queriesList.length; i++) {
            queries[i] = new int[]{queriesList[i][0], queriesList[i][1], queriesList[i][2], i};
        }
        Arrays.sort(queries, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        UnionFind uf = new UnionFind(n);
        boolean[] ans = new boolean[queries.length];
        for (int i = 0, j = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int limit = query[2];
            while (j < edges.length && edges[j][2] < limit) {
                uf.union(edges[j][0], edges[j][1]);
                j++;
            }
            ans[query[3]] = uf.root(query[0]) == uf.root(query[1]);
        }
        return ans;
    }

    static class UnionFind {
        int[] arr;
        int[] size;

        public UnionFind(int n) {
            arr = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (size[p] < size[q]) {
                arr[p] = arr[q];
                size[q] += size[p];
            } else {
                arr[q] = arr[p];
                size[p] += size[q];
            }
        }
    }
}
