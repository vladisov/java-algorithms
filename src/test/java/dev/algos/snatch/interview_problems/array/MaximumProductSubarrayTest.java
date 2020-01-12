package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.dp.MaximumProductSubarray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-09
 */
class MaximumProductSubarrayTest {

    private MaximumProductSubarray instance;

    @BeforeEach
    void setUp() {
        instance = new MaximumProductSubarray();
    }

    @Test
    void productHappyPath() {
        int result = instance.maxProduct(new int[]{2, 3, -2, 4});
        assertThat(result, equalTo(6));
    }

    @Test
    void productZeroResult() {
        int result = instance.maxProduct(new int[]{-2, 0, -1});
        assertThat(result, equalTo(0));
    }

    @Test
    void productEmptyArray() {
        int result = instance.maxProduct(new int[]{});
        assertThat(result, equalTo(0));
    }
}