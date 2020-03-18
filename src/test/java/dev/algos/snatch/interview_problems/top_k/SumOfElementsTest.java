package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SumOfElementsTest {

    @Test
    void test() {
        SumOfElements instance = new SumOfElements();
        assertThat(instance.findSumOfElements(new int[]{1, 3, 12, 5, 15, 11}, 3, 6), equalTo(23));
        assertThat(instance.findSumOfElementsAlternative(new int[]{1, 3, 12, 5, 15, 11}, 3, 6), equalTo(23));
    }
}
