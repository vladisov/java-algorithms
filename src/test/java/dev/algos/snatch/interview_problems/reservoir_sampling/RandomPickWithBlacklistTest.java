package dev.algos.snatch.interview_problems.reservoir_sampling;

import org.junit.jupiter.api.Test;

class RandomPickWithBlacklistTest {

    @Test
    void test() {
        RandomPickWithBlacklist instance = new RandomPickWithBlacklist(6, new int[]{0, 2, 3});
        instance.pick();
    }
}
