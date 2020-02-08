package dev.algos.snatch.interview_problems.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class InsertIntervalTest {

    private InsertInterval instance = new InsertInterval();

    @Test
    void testInsertSuccess() {
        var result = instance.insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}}, new int[]{2, 5});
        assertThat(Arrays.deepToString(result), equalTo("[[1, 5], [6, 9]]"));
    }

    @Test
    void testInsertMergeFew() {
        var result = instance.insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}, new int[]{10, 12}}, new int[]{2, 11});
        assertThat(Arrays.deepToString(result), equalTo("[[1, 12]]"));
    }

    @Test
    void testInsertAtEnd() {
        var result = instance.insert(new int[][]{new int[]{1, 3}, new int[]{6, 9}, new int[]{10, 12}}, new int[]{14, 16});
        assertThat(Arrays.deepToString(result), equalTo("[[1, 3], [6, 9], [10, 12], [14, 16]]"));
    }
}
