package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

/**
 * @author vladov 2020-01-07
 */
class FourSumTest {

    private FourSum instance;

    @BeforeEach
    void setUp() {
        instance = new FourSum();
    }

    @Test
    void testFourSumHappyPath() {
        var result = instance.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2);
        assertThat(result, hasItems(List.of(-2, 0, 2, 2), List.of(-1, 0, 1, 2)));
    }

    @Test
    void testFourSumHappyPath2() {
        var result = instance.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1);
        assertThat(result, hasItems(List.of(-3, -1, 1, 4), List.of(-3, 1, 1, 2)));
    }

    @Test
    void testFourSumEmpty() {
        var result = instance.searchQuadruplets(new int[0], 0);
        assertThat(result, equalTo(List.of()));
    }
}