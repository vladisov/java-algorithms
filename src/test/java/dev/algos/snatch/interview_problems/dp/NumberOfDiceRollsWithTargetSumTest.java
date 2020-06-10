package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfDiceRollsWithTargetSumTest {

    @Test
    void test() {
        NumberOfDiceRollsWithTargetSum instance = new NumberOfDiceRollsWithTargetSum();
        assertEquals(222616187, instance.numRollsToTarget(30, 30, 500));
        assertEquals(222616187, instance.numRollsToTargetBU(30, 30, 500));
    }
}
