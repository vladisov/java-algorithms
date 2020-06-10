package dev.algos.snatch.interview_problems.prefix_sum;

/**
 * Given an unsorted list of start and end time ( a range basically),
 * find any number within all the ranges that occurs in maximum number of intervals.
 * Example: [[1,4],[3,5],[4,6]] .
 */
public class MostFrequentValueInIntervals {

    static int MAX = 1000000;

    /**
     * Time O(N) if no need to sort and O(NlogN) if sort
     */
    public int findMostFrequent(int[][] intervals) {
        //sort if unsorted
        // Initalising all element of array to 0.
        int[] arr = new int[MAX];
        // Adding +1 at Li index and
        // substracting 1 at Ri index.
        int max = -1;
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            arr[left]++;
            arr[right + 1]--;
            max = Math.max(right, max);
        }

        int msum = arr[0], index = 0;
        for (int i = 1; i <= max; i++) {
            arr[i] += arr[i - 1];
            if (msum < arr[i]) {
                msum = arr[i];
                index = i;
            }
        }
        return index;
    }
}
