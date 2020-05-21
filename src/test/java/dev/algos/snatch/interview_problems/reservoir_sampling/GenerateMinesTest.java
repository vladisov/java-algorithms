package dev.algos.snatch.interview_problems.reservoir_sampling;

import org.junit.jupiter.api.Test;

class GenerateMinesTest {

    @Test
    void test() {
        GenerateMines instance = new GenerateMines();
        instance.generateBombs(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
    }
}
