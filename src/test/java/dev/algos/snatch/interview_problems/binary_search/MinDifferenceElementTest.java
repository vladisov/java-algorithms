package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinDifferenceElementTest {

    @Test
    void test() {
        MinDifferenceElement instance = new MinDifferenceElement();
        assertThat(instance.searchMinDiffElement(new int[]{4, 6, 10}, 7), equalTo(6));
        assertThat(instance.searchMinDiffElement(new int[]{1, 3, 8, 10, 15}, 12), equalTo(10));
        assertThat(instance.searchMinDiffElement(new int[]{4, 6, 10}, 17), equalTo(10));
        assertThat(instance.searchMinDiffElement(new int[]{4, 6, 10}, 4), equalTo(4));
    }
}
