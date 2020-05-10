package dev.algos.snatch.interview_problems.top_k;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * <p>
 * You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.
 * <p>
 * Return the maximum number of events you can attend.
 * Example 1:
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 */
public class MaxEventsAttended {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int day = 0, event = 0, count = 0, n = events.length;
        while (!queue.isEmpty() || event < n) {
            while (event < n && events[event][0] <= day) { // events for the same day
                queue.add(events[event++][1]);
            }
            while (!queue.isEmpty() && day > queue.peek()) { // remove all events that are already passed
                queue.poll();
            }
            if (!queue.isEmpty()) { // choose one
                count++;
                queue.poll();
            }
            day++;
        }
        return count;
    }
}
