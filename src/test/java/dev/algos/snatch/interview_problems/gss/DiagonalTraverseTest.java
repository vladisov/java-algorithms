package dev.algos.snatch.interview_problems.gss;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DiagonalTraverseTest {

    private DiagonalTraverse solution = new DiagonalTraverse();

    @Test
    void traverse() {
        int[] result = solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        assertThat(result).isEqualTo(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9});
        assertThat(solution.findDiagonalOrder(null)).isEqualTo(new int[0]);
    }
}
