package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private ContainsDuplicate containsDuplicate = new ContainsDuplicate();

    @Test
    void hasDuplicate() {
        assertTrue(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));
        assertTrue(containsDuplicate.containsDuplicate(new int[]{1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void noDuplicate() {
        assertFalse(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));
        assertFalse(containsDuplicate.containsDuplicate(new int[]{10, -2, 80000}));
    }
}
