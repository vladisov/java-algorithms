package dev.algos.snatch.interview_problems.k_way_merge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class KthSmallestInMSortedArraysTest {

    @Test
    void test() {
        //L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
        KthSmallestInMSortedArrays instance = new KthSmallestInMSortedArrays();
        assertThat(instance.findKthSmallest(List.of(new Integer[]{2, 6, 8},
                new Integer[]{3, 6, 7}, new Integer[]{1, 3, 4}), 5), equalTo(4));

        //L1=[5, 8, 9], L2=[1, 7], K=3
        assertThat(instance.findKthSmallest(List.of(new Integer[]{5, 8, 9},
                new Integer[]{1, 7}), 3), equalTo(7));

        assertThat(instance.findKthSmallest(List.of(new Integer[]{5, 8, 9},
                new Integer[]{1, 7}), 5), equalTo(9));
    }
}
