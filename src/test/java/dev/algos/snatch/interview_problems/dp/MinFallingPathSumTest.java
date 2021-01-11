package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinFallingPathSumTest {

    @Test
    void test() {
        assertEquals(-268, MinFallingPathSumKt.minFallingPathSum(new int[][]{{-37, 51, -36, 34, -22}, {82, 4, 30, 14, 38}, {-68, -52, -92, 65, -85}, {-49, -3, -77, 8, -19}, {-60, -71, -21, -62, -73}}));
    }
}
