package dev.algos.snatch.interview_problems.greedy;

/**
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
 * <p>
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * <p>
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * <p>
 * Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.
 */
public class MinTapsToOpenToWaterGarden {

    /**
     * Time O(N)
     * Space O(N)
     */
    public static int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(0, i - ranges[i]);
            arr[left] = Math.max(arr[left], i + ranges[i]);
        }

        int currEnd = 0, maxEnd = 0, count = 0;
        for (int i = 0; i <= n && currEnd < n; currEnd = maxEnd) {
            count++;
            while (i <= n && i <= currEnd) {
                maxEnd = Math.max(maxEnd, arr[i++]);
            }
            if (maxEnd == currEnd) return -1;
        }

        return count;
    }
}
