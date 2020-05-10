package dev.algos.snatch.interview_problems.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CriticalRoutersTest {

    @Test
    void test() {
        CriticalRouters criticalRouters = new CriticalRouters();
        List<Integer> result = criticalRouters.findAllArticulationPoints(7, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}});
        assertEquals("[5, 2, 3]", result.toString());
    }

}
