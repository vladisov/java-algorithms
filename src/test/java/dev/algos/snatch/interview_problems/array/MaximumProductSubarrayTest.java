package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTest {

    private MaximumProductSubarray solution = new MaximumProductSubarray();

    @Test
    void maxProduct() {
        assertEquals(6, solution.maxProduct(new int[]{2, 3, -2, 4}));
        assertEquals(0, solution.maxProduct(new int[]{-2,0,-1}));
    }
}
