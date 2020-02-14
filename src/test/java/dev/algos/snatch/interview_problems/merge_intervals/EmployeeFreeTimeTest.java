package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.algos.snatch.interview_problems.helpers.Interval.buildList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EmployeeFreeTimeTest {

    private EmployeeFreeTime instance = new EmployeeFreeTime();

    @Test
    void testEmployeeFreeTime() {
        List<List<Interval>> input = List.of(buildList("[[1,3], [5,6]]"), buildList("[[2,3], [6,8]]"));
        List<Interval> result = instance.findEmployeeFreeTime(input);
        assertThat(result.toString(), equalTo("[[3, 5]]"));
    }

    @Test
    void testEmployeeFreeTimeEdu() {
        List<List<Interval>> input = List.of(buildList("[[1,3], [5,6]]"), buildList("[[2,3], [6,8]]"));
        List<Interval> result = instance.findEmployeeFreeTimeEducative(input);
        assertThat(result.toString(), equalTo("[[3, 5]]"));
    }

    @Test
    void testEmployeeFreeTime2() {
        List<List<Interval>> input = List.of(buildList("[[1,3], [9,12]]"), buildList("[[2,4]], [[6,8]]"));
        List<Interval> result = instance.findEmployeeFreeTime(input);
        assertThat(result.toString(), equalTo("[[4, 6], [8, 9]]"));
    }
}
