package dev.algos.snatch.interview_problems.dijkstra;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumFlightsWithKStopsTest {

    @Test
    void test() {
        MinimumFlightsWithKStops instance = new MinimumFlightsWithKStops();
        int cheapestPrice = instance.findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2);
        assertEquals(7, cheapestPrice);
    }
}
