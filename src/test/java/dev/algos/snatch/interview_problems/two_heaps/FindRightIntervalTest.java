package dev.algos.snatch.interview_problems.two_heaps;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindRightIntervalTest {

    private FindRightInterval instance = new FindRightInterval();

    @Test
    void testBaseCase() {
        int[] result = instance.findRightInterval(new int[][]{{1, 2}, {2, 3}, {0, 1}, {3, 4}});
        assertThat(result, equalTo(new int[]{1, 3, 0, -1}));
    }

    @Test
    void testBaseCase2() {
        int[] result = instance.findRightInterval(new int[][]{{3, 4}, {1, 5}, {4, 6}});
        assertThat(result, equalTo(new int[]{2, -1, -1}));
    }

    @Test
    void testBaseCase3() {
        int[] result = instance.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}});
        assertThat(result, equalTo(new int[]{-1, 2, -1}));
    }
}