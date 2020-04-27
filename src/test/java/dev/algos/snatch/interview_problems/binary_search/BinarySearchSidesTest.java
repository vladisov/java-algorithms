package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchSidesTest {

    @Test
    void test() {
        BinarySearchSides bs = new BinarySearchSides();
        int[] arr = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        assertEquals(4, bs.binarySearchLeft(arr, 1));
        assertEquals(9, bs.binarySearchRight(arr, 1));
    }
}
