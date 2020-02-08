package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Problem Statement #
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 * <p>
 * Example 1:
 * <p>
 * Appointments: [[1,4], [2,5], [7,9]]
 * Output: false
 * Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
 * Example 2:
 * <p>
 * Appointments: [[6,7], [2,4], [8,12]]
 * Output: true
 * Explanation: None of the appointments overlap, therefore a person can attend all of them.
 * Example 3:
 * <p>
 * Appointments: [[4,5], [2,3], [3,6]]
 * Output: false
 * Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
 */
public class ConflictingAppointments {

    public boolean canAttendAllAppointments(Interval[] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(Interval::getStart));
        int end = intervals[0].getEnd();
        for (int i = 1; i < intervals.length; i++) {
            var curr = intervals[i];
            if (end >= curr.getStart()) {
                return false;
            } else {
                end = curr.getEnd();
            }
        }
        return true;
    }
}
