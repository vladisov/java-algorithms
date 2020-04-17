package dev.algos.snatch.interview_problems.two_pointers;

import dev.algos.snatch.interview_problems.max_area.LargestRectangleInHistogram;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LargestRectangleInHistogramTest {

    @Test
    void test() {
        LargestRectangleInHistogram lrh = new LargestRectangleInHistogram();
        assertEquals(10, lrh.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
