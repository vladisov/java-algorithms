package dev.algos.snatch.interview_problems.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculator_IITest {

    @Test
    void test() {
        BasicCalculator_II instance = new BasicCalculator_II();
        int evaluate = instance.evaluate("3+2*2");
        assertEquals(7, evaluate);
    }
}
