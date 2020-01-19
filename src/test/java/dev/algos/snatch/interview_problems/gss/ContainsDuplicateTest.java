package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.hash_table.ContainsDuplicate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author vladov 2019-12-08
 */
class ContainsDuplicateTest {


    private ContainsDuplicate instance;

    @BeforeEach
    void setUp() {
        instance = new ContainsDuplicate();
    }

    @Test
    void testContainsHappyPath() {
        boolean result = instance.containsDuplicate(new int[]{1, 2, 3, 1});
        assertThat(result, equalTo(true));
        assertTrue(instance.containsDuplicate(new int[]{1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void testContainsNot() {
        boolean result = instance.containsDuplicate(new int[]{1, 2, 3, 4});
        assertThat(result, equalTo(false));
        assertFalse(instance.containsDuplicate(new int[]{10, -2, 80000}));
    }

    @Test
    void testContainsEmptyArr() {
        boolean result = instance.containsDuplicate(new int[]{});
        assertThat(result, equalTo(false));
    }
}
