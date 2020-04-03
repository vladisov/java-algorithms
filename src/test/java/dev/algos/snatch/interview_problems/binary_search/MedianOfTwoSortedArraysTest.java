package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianOfTwoSortedArraysTest {

    @Test
    void test() {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        int[] x = {1, 3, 8, 9, 15};
        int[] y = {7, 11, 19, 21, 18, 25};
        assertEquals(11.0, medianOfTwoSortedArrays.findMedianSortedArrays(x, y));
    }
}
