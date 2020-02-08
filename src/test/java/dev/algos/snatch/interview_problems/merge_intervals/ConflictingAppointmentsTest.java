package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ConflictingAppointmentsTest {

    private ConflictingAppointments instance = new ConflictingAppointments();

    @Test
    void testConflicts() {
        assertThat(instance.canAttendAllAppointments(Interval.buildArray("[[1, 4], [2, 5], [7, 9]]")), equalTo(false));
    }

    @Test
    void testConflictsNoneExists() {
        assertThat(instance.canAttendAllAppointments(Interval.buildArray("[[6, 7], [2, 4], [8, 12]]")), equalTo(true));
    }

    @Test
    void testConflicts2() {
        assertThat(instance.canAttendAllAppointments(Interval.buildArray("[[4, 5], [2, 3], [3, 6]]")), equalTo(false));
    }
}
