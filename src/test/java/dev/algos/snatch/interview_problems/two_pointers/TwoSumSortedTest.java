package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-27
 */
class TwoSumSortedTest {

    private TwoSumSorted instance;

    @BeforeEach
    void setUp() {
        instance = new TwoSumSorted();
    }

    @Test
    void testSearchHappyPath() {
        var result = instance.search(new int[]{1, 2, 3, 4, 6}, 6);
        assertThat(result, equalTo(new int[]{1, 3}));
    }

    @Test
    void testSearchHappyPath2() {
        var result = instance.search(new int[]{2, 5, 9, 11}, 11);
        assertThat(result, equalTo(new int[]{0, 2}));
    }

    @Test
    void testSearchNegatives() {
        var result = instance.search(new int[]{-14, -9, -6, 2}, -4);
        assertThat(result, equalTo(new int[]{2, 3}));
    }

    @Test
    void testSearchEmpty() {
        var result = instance.search(new int[]{}, 2);
        assertThat(result, equalTo(new int[]{-1, -1}));
    }
}