package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement #
 * Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
 * Output: [2, 3], [5, 6], [7, 7]
 * Explanation: The output list contains the common intervals between the two lists.
 * Example 2:
 * <p>
 * Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
 * Output: [5, 7], [9, 10]
 * Explanation: The output list contains the common intervals between the two lists.
 */
public class IntervalsIntersection {

    /**
     * Time complexity O(n + m)
     * Space complexity O(n)
     */
    public Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            var first = arr1[i];
            var sec = arr2[j];
            if (first.getStart() > sec.getEnd()) {
                j++;
            } else if (sec.getStart() > first.getEnd()) {
                i++;
            } else {
                int start = Math.max(first.getStart(), sec.getStart());
                int end = Math.min(first.getEnd(), sec.getEnd());
                intervalsIntersection.add(new Interval(start, end));
                if (first.getEnd() > sec.getEnd()) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        return intervalsIntersection.toArray(new Interval[0]);
    }

    public int[][] intervalIntersectionLeetcode(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            var first = A[i];
            var sec = B[j];
            if (first[0] > sec[1]) {
                j++;
            } else if (sec[0] > first[1]) {
                i++;
            } else {
                int start = Math.max(first[0], sec[0]);
                int end = Math.min(first[1], sec[1]);
                list.add(new int[]{start, end});
                if (first[1] > sec[1]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        i = 0;
        for (int[] interval : list) {
            res[i++] = interval;
        }
        return res;
    }
}
