package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BinarySearchTemplateTest {

    private BinarySearchTemplate bs = new BinarySearchTemplate();

    @Test
    void testBase() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(bs.classicBinarySearch(arr, 3), equalTo(2));
        assertThat(bs.binarySearchRight(arr, 3), equalTo(2));
        assertThat(bs.binarySearchLeftAndRight(arr, 3), equalTo(2));
    }

    @Test
    void testNotFound() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(bs.classicBinarySearch(arr, 11), equalTo(-1));
        assertThat(bs.binarySearchRight(arr, 11), equalTo(-1));
        assertThat(bs.binarySearchLeftAndRight(arr, 11), equalTo(-1));
    }
}
