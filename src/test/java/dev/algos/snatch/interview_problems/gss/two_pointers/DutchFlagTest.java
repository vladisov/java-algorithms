package dev.algos.snatch.interview_problems.gss.two_pointers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DutchFlagTest {

    private DutchFlag solution = new DutchFlag();

    @Test
    void sort() {
        var input = new int[]{1, 0, 2, 1, 0};
        solution.sort(input);
        assertThat(input).containsExactly(0, 0, 1, 1, 2);

        input = new int[]{2, 2, 0, 1, 2, 0};
        solution.sort(input);
        assertThat(input).containsExactly(0, 0, 1, 2, 2, 2);
    }
}
