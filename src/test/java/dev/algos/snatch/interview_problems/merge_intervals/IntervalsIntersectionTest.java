package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dev.algos.snatch.interview_problems.helpers.Interval.buildArray;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntervalsIntersectionTest {

    private IntervalsIntersection instance = new IntervalsIntersection();

    @Test
    void testMerge() {
        Interval[] result = instance.merge(buildArray("[[1, 3], [5, 6], [7, 9]]"), buildArray("[[2, 3], [5, 7]]"));
        assertThat(Arrays.toString(result), equalTo("[[2, 3], [5, 6], [7, 7]]"));
    }

    @Test
    void testMergeSec() {
        Interval[] result = instance.merge(buildArray("[[1, 3], [5, 7], [9, 12]]"), buildArray("[[5, 10]]"));
        assertThat(Arrays.toString(result), equalTo("[[5, 7], [9, 10]]"));
    }

    @Test
    void testMergeLc() {
        Interval[] result = instance.merge(buildArray("[[0, 5], [12, 14], [15, 18]]"), buildArray("[[11, 15], [18, 19]]"));
        assertThat(Arrays.toString(result), equalTo("[[12, 14], [15, 15], [18, 18]]"));
    }
}
