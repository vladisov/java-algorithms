package dev.algos.snatch.interview_problems.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingPathTest {

    @Test
    void test() {
        LongestIncreasingPath instance = new LongestIncreasingPath();
        assertEquals(4, instance.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
    }
}
