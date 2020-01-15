package dev.algos.snatch.interview_problems.array.two_pointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PairWithTargetSumTest {

    private PairWithTargetSum solution = new PairWithTargetSum();

    @Test
    void pairWithTargetSum() {
        assertThat(solution.search(new int[]{1, 2, 3, 4, 6}, 6)).containsExactly(1, 3);
        assertThat(solution.search(new int[]{2, 5, 9, 11}, 11)).containsExactly(0, 2);
    }

}
