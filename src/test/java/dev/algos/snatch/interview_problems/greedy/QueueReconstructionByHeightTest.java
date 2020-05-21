package dev.algos.snatch.interview_problems.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueReconstructionByHeightTest {

    @Test
    void test() {
        var instance = new QueueReconstructionByHeight();

        int[][] result = instance.reconstructQueue(new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}});
        assertEquals("", Arrays.deepToString(result));
    }
}
