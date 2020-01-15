package dev.algos.snatch.interview_problems.array.two_pointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SquaringSortedArrayTest {

    private SquaringSortedArray solution = new SquaringSortedArray();


    @Test
    void squaring() {
        assertThat(solution.makeSquares(new int[]{-2, -1, 0, 2, 3})).containsExactly(0, 1, 4, 4, 9);
        assertThat(solution.makeSquares(new int[]{-3, -1, 0, 1, 2})).containsExactly(0, 1, 1, 4, 9);
        assertThat(solution.makeSquares(new int[]{-3, 0, 2})).containsExactly(0, 4, 9);
    }
}
