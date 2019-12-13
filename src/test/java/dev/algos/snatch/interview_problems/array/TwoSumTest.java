package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


class TwoSumTest {

    private TwoSum solution = new TwoSum();

    @Test
    @DisplayName("Valid solution")
    void validSolution() {
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] expected = new int[]{0, 1};
        assertThat(result, is(expected));
    }

    @Test
    @DisplayName("No result solution")
    void noResultsSolution() {
        int[] result = solution.twoSum(new int[]{1, 4, 6, 5}, 8);
        int[] expected = new int[]{-1, -1};
        assertThat(result, is(expected));
    }

}
