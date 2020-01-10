package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2020-01-09
 */
class MinimumWindowSortTest {


    private MinimumWindowSort instance;

    @BeforeEach
    void setUp() {
        instance = new MinimumWindowSort();
    }

    @Test
    void testSortHappyPath() {
        var result = instance.sort(new int[]{1, 2, 5, 3, 7, 10, 9, 12});
        assertThat(result, equalTo(5));
    }

    @Test
    void testSortArrayStart() {
        var result = instance.sort(new int[]{1, 3, 2, 0, -1, 7, 10});
        assertThat(result, equalTo(5));
    }

    @Test
    void testSortNoSort() {
        var result = instance.sort(new int[]{1, 2, 3});
        assertThat(result, equalTo(0));
    }

    @Test
    void testSortInTheMiddle() {
        var result = instance.sort(new int[]{1, 3, 8, 0, -1, 7, 10});
        assertThat(result, equalTo(6));
    }

    @Test
    void testSortEmpty() {
        var result = instance.sort(new int[]{});
        assertThat(result, equalTo(0));
    }

    @Test
    void testSortSameElements() {
        var result = instance.sort(new int[]{1, 2, 3, 3, 3});
        assertThat(result, equalTo(0));
    }
}