package dev.algos.snatch.interview_problems.array.two_pointers;

import dev.algos.snatch.interview_problems.array.two_pointers.FourSum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class FourSumTest {

    private FourSum solution = new FourSum();

    @Test
    void fourSum() {
        assertThat(solution.fourSum(new int[]{0,0,0,0}, 0))
                .containsExactly(Arrays.asList(0,0,0,0));

        assertThat(solution.fourSum(new int[]{5, 5, 3, 5, 1, -5, 1, -2}, 4))
                .containsExactly(Arrays.asList(-5, 1, 3, 5));

        assertThat(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0))
                .contains(Arrays.asList(-1, 0, 0, 1))
                .contains(Arrays.asList(-2, -1, 1, 2))
                .contains(Arrays.asList(-2, 0, 0, 2));
    }
}
