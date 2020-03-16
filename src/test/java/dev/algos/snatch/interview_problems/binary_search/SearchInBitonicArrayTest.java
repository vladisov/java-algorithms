package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SearchInBitonicArrayTest {

    @Test
    void test() {
        SearchInBitonicArray instance = new SearchInBitonicArray();
        assertThat(instance.search(new int[]{1, 3, 8, 4, 3}, 4), equalTo(3));
        assertThat(instance.search(new int[]{1, 3, 8, 4, 3}, 3), equalTo(1));
    }
}
