package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-29
 */
class RemoveDuplicatesTest {

    private RemoveDuplicates instance;

    @BeforeEach
    void setUp() {
        instance = new RemoveDuplicates();
    }

    @Test
    void testRemoveDuplicatesHappyPath() {
        var result = instance.remove(new int[]{2, 3, 3, 3, 6, 9, 9});
        assertThat(result, equalTo(4));
    }

    @Test
    void testRemoveDuplicatesHappyPath2() {
        var result = instance.remove(new int[]{2, 2, 2, 11});
        assertThat(result, equalTo(2));
    }

    @Test
    void testRemoveDuplicatesEmpty() {
        var result = instance.remove(new int[]{});
        assertThat(result, equalTo(0));
    }
}