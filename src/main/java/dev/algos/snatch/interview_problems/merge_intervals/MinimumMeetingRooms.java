package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Minimum Meeting Rooms (hard) #
 * Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
 * <p>
 * Example 1:
 * <p>
 * Meetings: [[1,4], [2,5], [7,9]]
 * Output: 2
 * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
 * occur in any of the two rooms later.
 * Example 2:
 * <p>
 * Meetings: [[6,7], [2,4], [8,12]]
 * Output: 1
 * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
 * Example 3:
 * <p>
 * Meetings: [[1,4], [2,3], [3,6]]
 * Output:2
 * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
 * hold all the meetings.
 * <p>
 * Example 4:
 * <p>
 * Meetings: [[4,5], [2,3], [2,4], [3,5]]
 * Output: 2
 * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
 */
public class MinimumMeetingRooms {

    public int findMinimumMeetingRooms(List<Interval> meetings) {
        if (meetings == null || meetings.isEmpty()) return 0;
        meetings.sort(Comparator.comparingInt(Interval::getStart));
        int end = meetings.get(0).getEnd(), num = 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(end);
        for (int i = 1; i < meetings.size(); i++) {
            var curr = meetings.get(i);
            if (end > curr.getStart()) {
                if (!minHeap.isEmpty() && minHeap.peek() < curr.getStart()) {
                    minHeap.poll();
                    minHeap.add(curr.getEnd());
                } else {
                    minHeap.add(end);
                    num++;
                }
                end = Math.min(end, curr.getEnd());
            } else {
                end = curr.getEnd();
            }
        }
        return num;
    }


    /**
     * Time complexity O(nlogn)
     * Space complexity O(n) for sorting
     */
    public int findMinimumMeetingRoomsEducative(List<Interval> meetings) {
        if (meetings == null || meetings.size() == 0)
            return 0;

        // sort the meetings by start time
        meetings.sort(Comparator.comparingInt(Interval::getStart));

        int minRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(Interval::getEnd));
        for (Interval meeting : meetings) {
            // remove all meetings that have ended
            while (!minHeap.isEmpty() && meeting.getStart() >= minHeap.peek().getEnd())
                minHeap.poll();
            // add the current meeting into the minHeap
            minHeap.offer(meeting);
            // all active meeting are in the minHeap, so we need rooms for all of them.
            minRooms = Math.max(minRooms, minHeap.size());
        }
        return minRooms;
    }
}
