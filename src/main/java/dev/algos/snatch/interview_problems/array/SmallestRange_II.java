package dev.algos.snatch.interview_problems.array;

import java.util.Arrays;

public class SmallestRange_II {

    /**
     * Time O(NlogN)
     * Space O(1)
     */
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int max = A[A.length - 1], min = A[0], ans = max - min;
        for (int i = 0; i < A.length - 1; i++) {
            max = Math.max(A[i] + 2 * K, max);
            min = Math.min(A[i + 1], A[0] + 2 * K);
            ans = Math.min(max - min, ans);
        }
        return ans;
    }
}
