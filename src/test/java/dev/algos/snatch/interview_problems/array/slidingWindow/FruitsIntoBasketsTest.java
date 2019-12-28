package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FruitsIntoBasketsTest {

    private FruitsIntoBaskets solution = new FruitsIntoBaskets();

    @Test
    void findLength() {
        assertEquals(3, solution.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        assertEquals(5, solution.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}
