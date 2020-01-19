package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-29
 */
class SortedArraySquaresTest {

    private SortedArraySquares instance;

    @BeforeEach
    void setUp() {
        instance = new SortedArraySquares();
    }

    @Test
    void testMakeSquaresHappyPath() {
        var result = instance.makeSquares(new int[]{-2, -1, 0, 2, 3});
        assertThat(result, equalTo(new int[]{0, 1, 4, 4, 9}));
    }

    @Test
    void testMakeSquaresHappyPath2() {
        var result = instance.makeSquares(new int[]{-3, -1, 0, 1, 2});
        assertThat(result, equalTo(new int[]{0, 1, 1, 4, 9}));
    }

    @Test
    void testMakeSquaresEmpty() {
        var result = instance.makeSquares(new int[]{});
        assertThat(result, equalTo(new int[]{}));
    }
}