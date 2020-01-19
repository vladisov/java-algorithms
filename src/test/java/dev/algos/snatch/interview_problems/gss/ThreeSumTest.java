package dev.algos.snatch.interview_problems.gss;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ThreeSumTest {

    private ThreeSum solution = new ThreeSum();

    @Test
    void threeSum() {
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(result)
                .contains(Arrays.asList(-1, 0, 1))
                .contains(Arrays.asList(-1, -1, 2));
    }
}
