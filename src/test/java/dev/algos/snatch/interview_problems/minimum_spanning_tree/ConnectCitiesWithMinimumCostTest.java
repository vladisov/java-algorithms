package dev.algos.snatch.interview_problems.minimum_spanning_tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConnectCitiesWithMinimumCostTest {

    @Test
    void test() {
        ConnectCitiesWithMinimumCost instance = new ConnectCitiesWithMinimumCost();
        assertEquals(6, instance.minimumCost(3, new int[][]{{1, 2, 5}, {1, 3, 6}, {2, 3, 1}}));
        assertEquals(-1, instance.minimumCost(4, new int[][]{{1, 2, 3}, {3, 4, 4}}));
        assertEquals(6, instance.minimumCost(4, new int[][]{{1, 2, 1}, {1, 3, 2}, {3, 4, 4}, {1, 4, 3}}));
    }
}
