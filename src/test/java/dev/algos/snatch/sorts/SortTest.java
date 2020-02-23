package dev.algos.snatch.sorts;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SortTest {

    private MergeSort mergeSort = new MergeSort();
    private QuickSort quickSort = new QuickSort();

    @Test
    void testMergeSort() {
        var arr = new int[]{5, 2, 1, -2, -4, 0};
        mergeSort.sort(arr);
        assertThat(arr, equalTo(new int[]{-4, -2, 0, 1, 2, 5}));
    }

    @Test
    void testQuickSort() {
        var arr = new int[]{5, 2, 1, -2, -4, 0};
        quickSort.sort(arr);
        assertThat(arr, equalTo(new int[]{-4, -2, 0, 1, 2, 5}));
    }
}
