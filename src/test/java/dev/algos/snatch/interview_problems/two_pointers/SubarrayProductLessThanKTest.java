package dev.algos.snatch.interview_problems.two_pointers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

/**
 * @author vladov 2020-01-06
 */
class SubarrayProductLessThanKTest {

    private SubarrayProductLessThanK instance;

    @BeforeEach
    void setUp() {
        instance = new SubarrayProductLessThanK();
    }

    @Test
    void testSubarrayProductHappyPath() {
        var result = instance.findSubarrays(new int[]{2, 5, 3, 10}, 30);
        assertThat(result, hasItems(List.of(2), List.of(5), List.of(2, 5),
                List.of(3), List.of(5, 3), List.of(10)));
    }

    @Test
    void testSubarrayProductHappyPath2() {
        var result = instance.findSubarrays(new int[]{8, 2, 6, 5}, 50);
        assertThat(result, hasItems(List.of(8), List.of(2), List.of(8, 2), List.of(6),
                List.of(2, 6), List.of(5), List.of(6, 5)));
    }
}