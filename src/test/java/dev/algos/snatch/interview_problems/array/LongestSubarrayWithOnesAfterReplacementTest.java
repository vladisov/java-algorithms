package dev.algos.snatch.interview_problems.array;

import dev.algos.snatch.interview_problems.sliding_window.LongestSubarrayWithOnesAfterReplacement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-25
 */
class LongestSubarrayWithOnesAfterReplacementTest {

    private LongestSubarrayWithOnesAfterReplacement instance;

    @BeforeEach
    void setUp() {
        instance = new LongestSubarrayWithOnesAfterReplacement();
    }

    @Test
    void findLengthSuccess() {
        int result = instance.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2);
        assertThat(result, equalTo(6));
    }


    @Test
    void findLengthSuccess2() {
        int result = instance.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3);
        assertThat(result, equalTo(9));
    }


    @Test
    void findLengthEmpty() {
        int result = instance.findLength(new int[]{}, 1);
        assertThat(result, equalTo(0));
    }

}