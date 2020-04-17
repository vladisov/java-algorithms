package dev.algos.snatch.interview_problems.two_pointers;

import dev.algos.snatch.interview_problems.max_area.TrappingRainWater;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    @Test
    void test() {
        TrappingRainWater trw = new TrappingRainWater();
        assertEquals(6, trw.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(6, trw.trapStack(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
