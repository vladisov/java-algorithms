package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MaximumDistinctElementsTest {

    @Test
    void test() {
        MaximumDistinctElements instance = new MaximumDistinctElements();
        assertThat(instance.findMaximumDistinctElements(new int[]{1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5}, 2), equalTo(3));
        assertThat(instance.findMaximumDistinctElements(new int[]{3, 5, 12, 11, 12}, 3), equalTo(2));
    }
}
