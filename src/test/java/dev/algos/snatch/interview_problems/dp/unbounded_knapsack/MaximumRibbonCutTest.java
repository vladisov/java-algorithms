package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumRibbonCutTest {

    @Test
    void test() {
        MaximumRibbonCut maximumRibbonCut = new MaximumRibbonCut();
        assertEquals(2, maximumRibbonCut.maxRibbonCut(new int[]{2, 3, 5}, 5));
        assertEquals(3, maximumRibbonCut.maxRibbonCut(new int[]{2, 3}, 7));
        assertEquals(3, maximumRibbonCut.maxRibbonCut(new int[]{3, 5, 7}, 13));

        assertEquals(2, maximumRibbonCut.maxRibbonCutBU(new int[]{2, 3, 5}, 5));
        assertEquals(3, maximumRibbonCut.maxRibbonCutBU(new int[]{2, 3}, 7));
        assertEquals(3, maximumRibbonCut.maxRibbonCutBU(new int[]{3, 5, 7}, 13));

        assertEquals(2, maximumRibbonCut.maxRibbonCutBUOptimized(new int[]{2, 3, 5}, 5));
        assertEquals(3, maximumRibbonCut.maxRibbonCutBUOptimized(new int[]{2, 3}, 7));
        assertEquals(3, maximumRibbonCut.maxRibbonCutBUOptimized(new int[]{3, 5, 7}, 13));
    }

}
