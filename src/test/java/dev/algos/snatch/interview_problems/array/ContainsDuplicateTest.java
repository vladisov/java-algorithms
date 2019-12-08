package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
    }

    @Test
    void testContainsNot() {
        boolean result = instance.containsDuplicate(new int[]{1, 2, 3, 4});
        assertThat(result, equalTo(false));
    }

    @Test
    void testContainsEmptyArr() {
        boolean result = instance.containsDuplicate(new int[]{});
        assertThat(result, equalTo(false));
    }
}