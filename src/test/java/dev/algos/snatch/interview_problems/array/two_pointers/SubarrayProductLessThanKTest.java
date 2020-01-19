package dev.algos.snatch.interview_problems.array.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubarrayProductLessThanKTest {

    private SubarrayProductLessThanK solution = new SubarrayProductLessThanK();

    @Test
    void find() {
        var lists = List.of(List.of(2), List.of(3), List.of(5), List.of(10), List.of(2, 5), List.of(5, 3));
        assertThat(solution.findSubArrays(new int[]{2, 5, 3, 10}, 30)).containsAll(lists);

        lists = List.of(List.of(2), List.of(6), List.of(5), List.of(8), List.of(8, 2), List.of(2, 6), List.of(6, 5));
        assertThat(solution.findSubArrays(new int[]{8, 2, 6, 5}, 50)).containsAll(lists);
    }

}
