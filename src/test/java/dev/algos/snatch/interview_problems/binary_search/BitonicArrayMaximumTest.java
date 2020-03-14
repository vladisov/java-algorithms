package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BitonicArrayMaximumTest {

    @Test
    void test() {
        BitonicArrayMaximum instance = new BitonicArrayMaximum();
        assertThat(instance.findMax(new int[]{4, 6, 10, 12}), equalTo(12));
        assertThat(instance.findMax(new int[]{1, 3, 8, 12, 4, 2}), equalTo(12));
        assertThat(instance.findMax(new int[]{3, 8, 3, 1}), equalTo(8));
    }
}
