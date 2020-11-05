package dev.algos.snatch.interview_problems.graph;

import java.util.HashMap;
import java.util.Map;

public class LargestComponentByFactor {

    /**
     * Time O(N*sqrt(max(A[i]))
     * Space O(N)
     */
    public int largestComponentSize(int[] A) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 2; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        uf.union(i, map.get(j));
                    }
                    if (!map.containsKey(A[i] / j)) {
                        map.put(A[i] / j, i);
                    } else {
                        uf.union(i, map.get(A[i] / j));
                    }
                }
            }
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            } else {
                uf.union(i, map.get(A[i]));
            }
        }
        return uf.max;
    }

    static class UnionFind {
        int[] arr;
        int[] size;
        int max = 1;

        public UnionFind(int n) {
            this.arr = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b) {
            int i = root(a);
            int j = root(b);
            if (i == j) return;
            if (size[i] < size[j]) {
                arr[i] = arr[j];
                size[j] += size[i];
                max = Math.max(size[j], max);
            } else {
                arr[j] = arr[i];
                size[i] += size[j];
                max = Math.max(size[i], max);
            }
        }

        public int root(int i) {
            while (i != arr[i]) {
                arr[i] = arr[arr[i]];
                i = arr[i];
            }
            return i;
        }
    }
}
