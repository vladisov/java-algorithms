package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class KthSmallestNumberTest {

    @Test
    void test() {
        KthSmallestNumber instance = new KthSmallestNumber();
        assertThat(instance.findKthSmallestNumberMaxHeap(new int[]{1, 5, 12, 2, 11, 5}, 3), equalTo(5));
        assertThat(instance.findKthSmallestNumberMaxHeap(new int[]{1, 5, 12, 2, 11, 5}, 4), equalTo(5));
        assertThat(instance.findKthSmallestNumberMaxHeap(new int[]{5, 12, 11, -1, 12}, 3), equalTo(11));

        assertThat(instance.findKthSmallestNumberQuickSort(new int[]{1, 5, 12, 2, 11, 5}, 3), equalTo(5));
        assertThat(instance.findKthSmallestNumberQuickSort(new int[]{1, 5, 12, 2, 11, 5}, 4), equalTo(5));
        assertThat(instance.findKthSmallestNumberQuickSort(new int[]{5, 12, 11, -1, 12}, 3), equalTo(11));
    }

}
