package dev.algos.snatch.data_structures.union_find;

import java.util.Arrays;

public class UnionFind {
    int[] arr;
    int[] size;

    public UnionFind(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    void union(int a, int b) {
        int i = root(a);
        int j = root(b);
        arr[i] = j;
    }

    private int root(int i) {
        while (i != arr[i]) {
            arr[i] = arr[arr[i]];
            i = arr[i];
        }
        return i;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
