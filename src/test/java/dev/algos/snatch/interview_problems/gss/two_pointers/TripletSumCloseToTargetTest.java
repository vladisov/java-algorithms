package dev.algos.snatch.interview_problems.gss.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TripletSumCloseToTargetTest {

    private TripletSumCloseToTarget solution = new TripletSumCloseToTarget();


    @Test
    void searchTriplet() {
        assertEquals(1, solution.searchTriplet(new int[]{-2, 0, 1, 2}, 2));
        assertEquals(0, solution.searchTriplet(new int[]{-3, -1, 1, 2}, 1));
        assertEquals(3, solution.searchTriplet(new int[]{1, 0, 1, 1}, 100));
    }

}
