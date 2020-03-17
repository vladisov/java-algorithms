package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TopKFrequentElementsTest {

    @Test
    void test() {
        TopKFrequentElements instance = new TopKFrequentElements();
        assertThat(instance.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2).toString(), equalTo("[2, 1]"));
    }
}
