package dev.algos.snatch.interview_problems.two_heaps;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.PriorityQueue;

/**
 *
 */
public class FindRightInterval {

    public int[] findRightIntervalEducative(Interval[] intervals) {
        int n = intervals.length;
        // heap for finding the maximum start
        PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].getStart() - intervals[i1].getStart());
        // heap for finding the minimum end
        PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].getEnd() - intervals[i1].getEnd());
        int[] result = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            maxStartHeap.offer(i);
            maxEndHeap.offer(i);
        }

        // go through all the intervals to find each interval's next interval
        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end'
            result[topEnd] = -1; // defaults to -1
            if (intervals[maxStartHeap.peek()].getStart() >= intervals[topEnd].getEnd()) {
                int topStart = maxStartHeap.poll();
                // find the the interval that has the closest 'start'
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].getStart() >= intervals[topEnd].getEnd()) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
            }
        }
        return result;
    }

    /**
     * Time complexity O(NlogN)
     * Space complexity O(N)
     */
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<Integer> maxEndHeap =
                new PriorityQueue<>((i1, i2) -> (intervals[i2][1] - intervals[i1][1]));
        PriorityQueue<Integer> maxStartHeap =
                new PriorityQueue<>((i1, i2) -> (intervals[i2][0] - intervals[i1][0]));
        for (int i = 0; i < intervals.length; i++) {
            maxEndHeap.add(i);
            maxStartHeap.add(i);
        }
        int n = intervals.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int topEnd = maxEndHeap.poll();
            result[topEnd] = -1; // def case
            if (intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
                int topStart = maxStartHeap.peek();
                while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()][0] >= intervals[topEnd][1]) {
                    topStart = maxStartHeap.poll();
                }
                result[topEnd] = topStart;
                maxStartHeap.add(topStart);
            }
        }
        return result;
    }
}
