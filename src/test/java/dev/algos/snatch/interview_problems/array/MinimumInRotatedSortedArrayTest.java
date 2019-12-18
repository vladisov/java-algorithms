package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumInRotatedSortedArrayTest {

    private MinimumInRotatedSortedArray solution = new MinimumInRotatedSortedArray();

    @Test
    void minimumInRotatedSortedArray() {
        assertEquals(1, solution.findMin(new int[]{3, 4, 5, 1, 2}));
        assertEquals(0, solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        assertEquals(1, solution.findMin(new int[]{1, 2, 3, 4, 5, 6, 7}));
        assertEquals(1, solution.findMin(new int[]{2, 1}));
        assertEquals(-1, solution.findMin(new int[0]));
        assertEquals(2, solution.findMin(new int[]{2}));
    }
}
