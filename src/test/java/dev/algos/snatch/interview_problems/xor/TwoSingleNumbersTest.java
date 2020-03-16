package dev.algos.snatch.interview_problems.xor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TwoSingleNumbersTest {

    @Test
    void test() {
        TwoSingleNumbers instance = new TwoSingleNumbers();
        assertThat(instance.findSingleNumbers(new int[]{1, 4, 2, 1, 3, 5, 6, 2, 3, 5}), equalTo(new int[]{6, 4}));
    }
}
