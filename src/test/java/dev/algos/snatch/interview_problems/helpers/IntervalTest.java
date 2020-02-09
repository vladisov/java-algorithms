package dev.algos.snatch.interview_problems.helpers;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntervalTest {

    @Test
    void testBuildList() {
        List<Interval> intervals = Interval.buildList("[[1, 3], [5, 6], [7, 9]]");
        assertThat(intervals.size(), equalTo(3));
        assertThat(intervals.toString(), equalTo("[[1, 3], [5, 6], [7, 9]]"));
    }

    @Test
    void testBuildListWoutSpaces() {
        List<Interval> intervals = Interval.buildList("[[1,3], [5,6], [7,9]]");
        assertThat(intervals.size(), equalTo(3));
        assertThat(intervals.toString(), equalTo("[[1, 3], [5, 6], [7, 9]]"));
    }
}
