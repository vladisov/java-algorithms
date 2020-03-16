package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CeilingOfNumberTest {

    @Test
    void test() {
        CeilingOfNumber instance = new CeilingOfNumber();
        assertThat(instance.searchCeilingOfANumber(new int[]{4, 6, 10}, 6), equalTo(1));
        assertThat(instance.searchCeilingOfANumber(new int[]{4, 6, 10}, 2), equalTo(0));
        assertThat(instance.searchCeilingOfANumber(new int[]{4, 6, 10}, 5), equalTo(1));
        assertThat(instance.searchCeilingOfANumber(new int[]{4, 6, 10}, 9), equalTo(2));
    }
}
