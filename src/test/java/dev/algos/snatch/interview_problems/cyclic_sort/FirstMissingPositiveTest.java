package dev.algos.snatch.interview_problems.cyclic_sort;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindSmallestMissingPositiveTest {

    private FirstSmallestMissingPositive instance = new FirstSmallestMissingPositive();

    @Test
    void testFind() {
        assertThat(instance.firstMissingPositive(new int[]{1, 2, 0}), equalTo(3));
    }
}
