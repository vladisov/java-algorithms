package dev.algos.snatch.data_structures.tree;

public class BIT {
    int[] tree;
    int n;

    public BIT(int[] arr) {
        this.n = arr.length;
        this.tree = new int[n + 1];
        for (int i = 0; i < n; i++) update(i, arr[i]);
    }

    void update(int i, int diff) {
        i++;
        while (i <= n) {
            tree[i] += diff;
            i += i & -i;
        }
    }

    int getSum(int i) {
        i++;
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    int getSumInRange(int l, int r) {
        return getSum(r) - getSum(l - 1);
    }
}
