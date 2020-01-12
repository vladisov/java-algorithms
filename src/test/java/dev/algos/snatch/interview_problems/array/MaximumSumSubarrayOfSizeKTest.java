package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.sliding_window.MaximumSumSubarrayOfSizeK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-19
 */
class MaximumSumSubarrayOfSizeKTest {

    private MaximumSumSubarrayOfSizeK instance;

    @BeforeEach
    void setUp() {
        instance = new MaximumSumSubarrayOfSizeK();
    }

    @Test
    void maxSubArrayHappyPath() {
        int result = instance.findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, 3);
        assertThat(result, equalTo(9));
    }


    @Test
    void maxSubArrayNegative() {
        int result = instance.findMaxSumSubArray(new int[]{-1, -2, -3, -4, -5, -6}, 3);
        assertThat(result, equalTo(-6));
    }
}