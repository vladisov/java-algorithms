package dev.algos.snatch.interview_problems.merge_intervals;

import org.junit.jupiter.api.Test;

import static dev.algos.snatch.interview_problems.helpers.Interval.buildList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinimumMeetingRoomsTest {

    private MinimumMeetingRooms instance = new MinimumMeetingRooms();

    @Test
    void testOneOverlap() {
        assertThat(instance.findMinimumMeetingRooms(buildList("[[1,4], [2,5], [7,9]]")), equalTo(2));
        assertThat(instance.findMinimumMeetingRoomsEducative(buildList("[[1,4], [2,5], [7,9]]")), equalTo(2));
    }

    @Test
    void testNoOverlap() {
        assertThat(instance.findMinimumMeetingRooms(buildList("[[6,7], [2,4], [8,12]]")), equalTo(1));
        assertThat(instance.findMinimumMeetingRoomsEducative(buildList("[[6,7], [2,4], [8,12]]")), equalTo(1));
    }

    @Test
    void testFewOverlaps() {
        assertThat(instance.findMinimumMeetingRooms(buildList("[[4,5], [2,3], [2,4], [3,5]]")), equalTo(2));
        assertThat(instance.findMinimumMeetingRoomsEducative(buildList("[[4,5], [2,3], [2,4], [3,5]]")), equalTo(2));
    }

}
