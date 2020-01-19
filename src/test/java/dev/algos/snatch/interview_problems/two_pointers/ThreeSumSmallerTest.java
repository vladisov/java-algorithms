package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2020-01-01
 */
class ThreeSumSmallerTest {

    private ThreeSumSmaller instance;

    @BeforeEach
    void setUp() {
        instance = new ThreeSumSmaller();
    }

    @Test
    void testThreeSumHappyPath() {
        var result = instance.searchTriplets(new int[]{-1, 0, 2, 3}, 3);
        assertThat(result, equalTo(2));
    }

    @Test
    void testThreeSumHappyPath2() {
        var result = instance.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5);
        assertThat(result, equalTo(4));
    }

    @Test
    void testThreeSumEmpty() {
        var result = instance.searchTriplets(new int[0], 5);
        assertThat(result, equalTo(0));
    }
}