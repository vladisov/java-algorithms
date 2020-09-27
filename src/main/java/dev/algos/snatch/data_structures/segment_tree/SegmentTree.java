package dev.algos.snatch.data_structures.segment_tree;

import dev.algos.snatch.interview_problems.bit.NextPowerOfTwo;

public class SegmentTree {

    int[] constructTree(int[] input) {
        NextPowerOfTwo nextPowerOfTwo = new NextPowerOfTwo();
        int nextPowTwo = nextPowerOfTwo.nextPowerOfTwo(input.length);
        int[] tree = new int[nextPowTwo * 2 - 1];
        constructTree(input, tree, 0, input.length - 1, 0);
        return input;
    }

    private void constructTree(int[] input, int[] tree, int lo, int hi, int pos) {
        if (lo == hi) {
            //coz this is parent
            tree[pos] = input[lo];
            return;
        }
        int mid = lo + (hi - lo) / 2;
        constructTree(input, tree, lo, mid, 2 * pos + 1);
        constructTree(input, tree, mid + 1, hi, 2 * pos + 2);
        tree[pos] = Math.min(tree[2 * pos + 1], tree[2 * pos + 2]);
    }


}
