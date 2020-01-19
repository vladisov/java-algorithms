package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.sliding_window.AverageSumSubarrayOfSizeK;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-19
 */
class AverageSumSubarrayOfSizeKTest {
    private AverageSumSubarrayOfSizeK instance;

    @BeforeEach
    void setUp() {
        instance = new AverageSumSubarrayOfSizeK();
    }

    @Test
    void avgSubArrayHappyPath() {
        double[] result = instance.findAverages(new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2}, 5);
        assertThat(result, equalTo(new double[]{2.2d, 2.8d, 2.4d, 3.6d, 2.8d}));
    }

    @Test
    void avgSubArrayEmpty() {
        double[] result = instance.findAverages(new int[]{}, 5);
        assertThat(result, equalTo(new double[]{}));
    }

    @Test
    void avgSubArrayZeroK() {
        double[] result = instance.findAverages(new int[]{1, 2, 3}, 0);
        assertThat(result, equalTo(new double[]{}));
    }

    @Test
    void avgSubArrayKGreaterThan() {
        double[] result = instance.findAverages(new int[]{1, 2, 3}, 4);
        assertThat(result, equalTo(new double[]{}));
    }
}
