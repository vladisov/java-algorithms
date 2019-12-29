package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author vladov 2019-12-29
 */
class ThreeSumTest {


    private ThreeSum instance;

    @BeforeEach
    void setUp() {
        instance = new ThreeSum();
    }

    @Test
    void testThreeSumHappyPath() {
        var result = instance.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertThat(result, hasItems(List.of(-1, 0, 1), List.of(-1, -1, 2)));
    }

    @Test
    void testThreeSumEmpty() {
        var result = instance.threeSum(new int[]{});
        assertThat(result, hasSize(0));
    }
}