package dev.algos.snatch.interview_problems.array.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestWindowSortTest {

    private ShortestWindowSort solution = new ShortestWindowSort();

    @Test
    void sort() {
        assertEquals(5, solution.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12}));
        assertEquals(5, solution.sort(new int[]{1, 3, 2, 0, -1, 7, 10}));
        assertEquals(0, solution.sort(new int[]{1, 2, 3}));
        assertEquals(3, solution.sort(new int[]{3, 2, 1}));
    }

}
