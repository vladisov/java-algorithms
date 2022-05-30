package dev.algos.snatch.data_structures.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BITTest {

    @Test
    void test() {
        int[] arr = {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};
        BIT tree = new BIT(arr);
        // Build fenwick tree from given array
        assertEquals(12, tree.getSum(5));
        arr[3] += 6;
        tree.update(3, 6);
        assertEquals(18, tree.getSum(5));
    }

}
