package dev.algos.snatch.interview_problems.two_heaps;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 22/02/2020
 */
class SlidingWindowMedianTest {

    private SlidingWindowMedian instance = new SlidingWindowMedian();

    @Test
    void testMedian() {
        double[] doubles = instance.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        assertThat(doubles, equalTo(new double[]{1, -1, -1, 3, 5, 6}));
    }
}