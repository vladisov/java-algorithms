package dev.algos.snatch.interview_problems.merge_intervals;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * <p>
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * LeetCode: <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 */
public class InsertInterval {

    /**
     * Time complexity O(n)
     * Space complexity O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        int i = 0;
        //add all before new interval int[i].end < newInt[start]
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }
        //then merge if int[i].start <= newInt[end]
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            int start = Math.min(newInterval[0], intervals[i][0]);
            int end = Math.max(newInterval[1], intervals[i][1]);
            newInterval = new int[]{start, end};
            i++;
        }
        list.add(newInterval);

        //add all others
        while (i < intervals.length) {
            list.add(intervals[i++]);
        }

        return list.toArray(new int[][]{new int[list.size()]});
    }
}
