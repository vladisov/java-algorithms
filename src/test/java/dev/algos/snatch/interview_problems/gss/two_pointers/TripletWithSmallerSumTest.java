package dev.algos.snatch.interview_problems.gss.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripletWithSmallerSumTest {

    private TripletWithSmallerSum solution = new TripletWithSmallerSum();

    @Test
    void searchTriplets() {
        assertEquals(2, solution.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        assertEquals(4, solution.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }

}
