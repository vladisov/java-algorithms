package dev.algos.snatch.interview_problems.dp;

import dev.algos.snatch.interview_problems.dp.knapsack.MinimumSubsetsSumDifference;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSubsetsSumDifferenceTest {

    @Test
    void test() {
        MinimumSubsetsSumDifference instance = new MinimumSubsetsSumDifference();
        assertEquals(3, instance.canPartition(new int[]{1, 2, 3, 9}));
        assertEquals(3, instance.canPartitionMemo(new int[]{1, 2, 3, 9}));
        assertEquals(3, instance.canPartitionBottomUpBF(new int[]{1, 2, 3, 9}));
        assertEquals(0, instance.canPartition(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, instance.canPartitionMemo(new int[]{1, 2, 7, 1, 5}));
        assertEquals(0, instance.canPartitionBottomUpBF(new int[]{1, 2, 7, 1, 5}));
        assertEquals(92, instance.canPartition(new int[]{1, 3, 100, 4}));
        assertEquals(92, instance.canPartitionMemo(new int[]{1, 3, 100, 4}));
        assertEquals(92, instance.canPartitionBottomUpBF(new int[]{1, 3, 100, 4}));
    }
}
