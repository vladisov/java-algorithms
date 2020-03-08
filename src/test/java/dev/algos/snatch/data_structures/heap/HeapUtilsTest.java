package dev.algos.snatch.data_structures.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HeapUtilsTest {

    @Test
    void testHeapify() {
        int[] arr = new int[]{2, 4, 5, 1, 9, 12};
        HeapUtils utils = new HeapUtils();
        utils.buildMaxHeap(arr);
        assertThat(Arrays.toString(arr), equalTo("[12, 9, 5, 1, 4, 2]"));

        utils.buildMinHeap(arr);
        assertThat(Arrays.toString(arr), equalTo("[1, 4, 2, 9, 12, 5]"));

        utils.heapSort(arr);
        assertThat(Arrays.toString(arr), equalTo("[1, 2, 4, 5, 9, 12]"));
    }
}
