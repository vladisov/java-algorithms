package dev.algos.snatch.interview_problems.helpers;

public class UnionFind {
    private int[] arr;
    private int size;

    public UnionFind(int n) {
        this.arr = new int[n + 1];
        this.size = n;
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
    }

    public int root(int i) {
        while (i != arr[i]) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

    public boolean union(int i, int j) {
        int p = root(i);
        int q = root(j);
        if (p == q) return false;
        arr[p] = q;
        size--;
        return true;
    }

    public int getSize() {
        return size;
    }
}
