package dev.algos.snatch.interview_problems.binary_search;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class OrderAgnosticBinarySearchTest {

    @Test
    void test() {
        OrderAgnosticBinarySearch bs = new OrderAgnosticBinarySearch();
        assertThat(bs.search(new int[]{1, 2, 3, 4, 5, 6, 7}, 5), equalTo(4));
        assertThat(bs.search(new int[]{10, 6, 4}, 10), equalTo(0));
        assertThat(bs.search(new int[]{10, 6, 4}, 5), equalTo(-1));
    }
}
