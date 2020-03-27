package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static dev.algos.snatch.interview_problems.binary_search.SearchInInfiniteNumberArray.ArrayReader;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SearchInInfiniteNumberArrayTest {

    @Test
    void test() {
        ArrayReader reader = new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30});
        SearchInInfiniteNumberArray instance = new SearchInInfiniteNumberArray();
        assertThat(instance.search(reader, 16), equalTo(6));
        assertThat(instance.search(reader, 11), equalTo(-1));
        reader = new ArrayReader(new int[]{1, 3, 8, 10, 15});
        assertThat(instance.search(reader, 15), equalTo(4));
        assertThat(instance.search(reader, 200), equalTo(-1));
    }
}
