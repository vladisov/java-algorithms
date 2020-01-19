package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author vladov 2020-01-01
 */
class ThreeSumCloseToTargetTest {

    private ThreeSumCloseToTarget instance;

    @BeforeEach
    void setUp() {
        instance = new ThreeSumCloseToTarget();
    }

    @Test
    void testThreeSumHappyPath() {
        var result = instance.searchTriplet(new int[]{-2, 0, 1, 2}, 2);
        assertThat(result, equalTo(1));
    }

    @Test
    void testThreeSumHappyPath2() {
        var result = instance.searchTriplet(new int[]{-3, -1, 1, 2}, 1);
        assertThat(result, equalTo(0));
    }

    @Test
    void testThreeSumHappyPath3() {
        var result = instance.searchTriplet(new int[]{1, 0, 1, 1}, 100);
        assertThat(result, equalTo(3));
    }

    @Test
    void testThreeSumEmpty() {
        assertThrows(IllegalArgumentException.class, () -> instance.searchTriplet(new int[]{}, 10));
    }
}