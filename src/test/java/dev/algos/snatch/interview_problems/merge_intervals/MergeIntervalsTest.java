package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MergeIntervalsTest {

    private MergeIntervals instance = new MergeIntervals();

    @Test
    void testSortedMerged() {
        var result = instance.merge(List.of(new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)));
        assertThat(result.toString(), equalTo("[[1, 5], [7, 9]]"));
    }

    @Test
    void testUnsortedMerged() {
        var result = instance.merge(List.of(new Interval(6, 7), new Interval(2, 4), new Interval(5, 9)));
        assertThat(result.toString(), equalTo("[[2, 4], [5, 9]]"));
    }

    @Test
    void testAllMerged() {
        var result = instance.merge(List.of(new Interval(1, 4), new Interval(2, 6), new Interval(3, 5)));
        assertThat(result.toString(), equalTo("[[1, 6]]"));
    }
}
