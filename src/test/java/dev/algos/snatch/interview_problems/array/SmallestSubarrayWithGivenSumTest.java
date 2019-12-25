package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.sliding_window.SmallestSubarrayWithGivenSum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class SmallestSubarrayWithGivenSumTest {

    private SmallestSubarrayWithGivenSum instance;

    @BeforeEach
    void setUp() {
        instance = new SmallestSubarrayWithGivenSum();
    }

    @Test
    void smallestSumSubArrayHappyPath() {
        int result = instance.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2});
        assertThat(result, equalTo(2));
    }

    @Test
    void smallestSumSubArraySingle() {
        int result = instance.findMinSubArray(7, new int[]{2, 1, 5, 2, 8});
        assertThat(result, equalTo(1));
    }


    @Test
    void smallestSumSubArrayThree() {
        int result = instance.findMinSubArray(8, new int[]{3, 4, 1, 1, 6});
        assertThat(result, equalTo(3));
    }

    @Test
    void smallestSumSubArrayEmpty() {
        int result = instance.findMinSubArray(2, new int[]{});
        assertThat(result, equalTo(0));
    }
}