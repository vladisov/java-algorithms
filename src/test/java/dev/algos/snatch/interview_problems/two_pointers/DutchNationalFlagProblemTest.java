package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2020-01-06
 */
class DutchNationalFlagProblemTest {

    private DutchNationalFlagProblem instance;

    @BeforeEach
    void setUp() {
        instance = new DutchNationalFlagProblem();
    }

    @Test
    void testSortHappyPath() {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        instance.sort(arr);
        assertThat(arr, equalTo(new int[]{0, 0, 1, 1, 2}));
    }

    @Test
    void testSortHappyPath2() {
        int[] arr = new int[]{2, 2, 0, 1, 2, 0};
        instance.sort(arr);
        assertThat(arr, equalTo(new int[]{0, 0, 1, 2, 2, 2}));
    }

    @Test
    void testSortEmpty() {
        int[] arr = new int[0];
        instance.sort(arr);
        assertThat(arr, equalTo(arr));
    }
}