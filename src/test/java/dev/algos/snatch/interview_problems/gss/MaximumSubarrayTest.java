package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.sliding_window.MaximumSubarray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-08
 */
class MaximumSubarrayTest {

    private MaximumSubarray instance;

    @BeforeEach
    void setUp() {
        instance = new MaximumSubarray();
    }

    @Test
    void productHappyPath() {
        int result = instance.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertThat(result, equalTo(6));
    }

    @Test
    void productHappyPath2() {
        int result = instance.maxSubArray(new int[]{-2, 5, -3, -7, -1, 1, 1, -5, 4});
        assertThat(result, equalTo(5));
    }

    @Test
    void productIncreasingValues() {
        int result = instance.maxSubArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        assertThat(result, equalTo(28));
    }

    @Test
    void productEmptyArray() {
        int result = instance.maxSubArray(new int[]{});
        assertThat(result, equalTo(0));
    }

    @Test
    void productSingleValueArray() {
        int result = instance.maxSubArray(new int[]{2});
        assertThat(result, equalTo(2));
    }
}
