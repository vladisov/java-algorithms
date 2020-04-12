package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce
 * a list that has only mutually exclusive intervals.
 * <p>
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into one [1,5].
 * <p>
 * Intervals: [[6,7], [2,4], [5,9]]
 * Output: [[2,4], [5,9]]
 * Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
 * <p>
 * Intervals: [[1,4], [2,6], [3,5]]
 * Output: [[1,6]]
 * Explanation: Since all the given intervals overlap, we merged them into one.
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/merge-intervals/">56. Merge Intervals</a>
 */
public class MergeIntervals {

    /**
     * Time complexity O(nlogn)
     * Space complexity O(n) sorting and result
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<>();
        if (intervals == null || intervals.size() == 0) {
            return mergedIntervals;
        }
        var inputCopy = new ArrayList<>(intervals);
        inputCopy.sort(Comparator.comparingInt(Interval::getStart));
        var first = inputCopy.get(0);
        int start = first.getStart();
        int end = first.getEnd();
        for (int i = 1; i < inputCopy.size(); i++) {
            var interval = inputCopy.get(i);
            if (end >= interval.getStart()) {
                end = Math.max(end, interval.getEnd());
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    /**
     * from leetcode
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
        List<int[]> list = new ArrayList<>();
        int[] first = intervals[0];
        int start = first[0];
        int end = first[1];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (end >= curr[0]) {
                end = Math.max(end, curr[1]);
            } else {
                list.add(new int[]{start, end});
                start = curr[0];
                end = curr[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[][]{new int[list.size()]});
    }
}
