package dev.algos.snatch.interview_problems.sliding_window;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/moving-stones-until-consecutive-ii/
 */
public class MovingStonesUntilConsecutiveII {


    public int[] numMovesStonesII(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length, lo = n;
        for (int start = 0, end = 0; end < n; end++) {
            while (arr[end] - arr[start] + 1 > n) start++; // shrink to find spot 101
            int alreadyStore = end - start + 1; // 2 | 101 - 100 + 1
            if (alreadyStore == n - 1 && arr[end] - arr[start] + 1 == n - 1) {
                lo = Math.min(lo, 2);
            } else {
                lo = Math.min(lo, n - alreadyStore);
            }
        }
        return new int[]{lo, Math.max(arr[n - 1] - arr[1] - n + 2, arr[n - 2] - arr[0] - n + 2)};
    }

}

