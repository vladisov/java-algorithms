package dev.algos.snatch.interview_problems.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfSubMatrixWithSumTargetTest {

    @Test
    void test() {
        NumberOfSubMatrixWithSumTarget scratch = new NumberOfSubMatrixWithSumTarget();
        assertEquals(4, scratch.numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
        assertEquals(4, scratch.numSubmatrixSumTargetPrefix(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
    }
}
