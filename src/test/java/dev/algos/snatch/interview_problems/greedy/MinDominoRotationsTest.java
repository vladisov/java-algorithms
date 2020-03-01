package dev.algos.snatch.interview_problems.greedy;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinDominoRotationsTest {

    MinDominoRotations instance = new MinDominoRotations();

    @Test
    void test() {
        assertThat(instance.minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}), equalTo(2));
    }
}
