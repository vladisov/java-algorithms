package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CanPartitionKSubsetsTest {

    @Test
    void test() {
        CanPartitionKSubsets instance = new CanPartitionKSubsets();
        assertTrue(instance.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
