package dev.algos.snatch.interview_problems.union_find;

public class MakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int cables = 0;
        for (int i = 0; i < connections.length; i++) {
            if (!uf.union(connections[i][0], connections[i][1])) {
                cables++;
            }
        }
        int comp = uf.getComponentsNum();
        if (comp == 1) {
            return 0;
        }
        if (cables >= comp - 1) {
            return comp - 1;
        }
        return -1;
    }

    static class UnionFind {
        int[] arr;
        int comp;

        public UnionFind(int n) {
            arr = new int[n];
            comp = n;
            for (int i = 0; i < n; i++) {
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

        int getComponentsNum() {
            return comp;
        }

        boolean union(int i, int j) {
            int p = root(i);
            int q = root(j);
            if (p == q) return false;
            arr[p] = q;
            comp--;
            return true;
        }

        boolean find(int i, int j) {
            return root(i) == root(j);
        }
    }
}
