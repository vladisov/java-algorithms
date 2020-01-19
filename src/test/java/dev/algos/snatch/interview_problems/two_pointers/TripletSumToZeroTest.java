package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TripletSumToZeroTest {

    private TripletSumToZero solution = new TripletSumToZero();

    @Test
    void search() {
        var result = List.of(List.of(-3, 1, 2), List.of(-2, 0, 2), List.of(-2, 1, 1), List.of(-1, 0, 1));
        assertThat(solution.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2})).containsAll(result);

        result = List.of(List.of(-5, 2, 3), List.of(-2, -1, 3));
        assertThat(solution.searchTriplets(new int[]{-5, 2, -1, -2, 3})).containsAll(result);
    }

}
