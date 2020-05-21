package dev.algos.snatch.interview_problems.prefix_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomPickWithWeightTest {

    @Test
    void test() {
        RandomPickWithWeight randomPickIndex = new RandomPickWithWeight(new int[]{1});
        assertEquals(0, randomPickIndex.pickIndex());
    }
}
