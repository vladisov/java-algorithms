package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 */
public class MaximumLengthRepeatingSubarray {

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;

        Integer[][][] dp = new Integer[A.length][B.length][Math.min(A.length, B.length) + 1];
        return findLengthRec(A, B, 0, 0, 0, dp);
    }

    private int findLengthRec(int[] A, int[] B, int i, int j, int count, Integer[][][] dp) {
        if (i >= A.length || j >= B.length) {
            return count;
        }

        if (dp[i][j][count] == null) {
            if (A[i] == B[j]) {
                count = findLengthRec(A, B, i + 1, j + 1, count + 1, dp);
            }
            int count2 = findLengthRec(A, B, i + 1, j, 0, dp);
            int count3 = findLengthRec(A, B, i, j + 1, 0, dp);
            dp[i][j][count] = Math.max(count, Math.max(count2, count3));
        }
        return dp[i][j][count];
    }

    public int findLengthBU(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;

        int[][] dp = new int[A.length + 1][B.length + 1];

        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    /**
     * Time O(a * b)
     * Space O(a * b)
     */
    public int findLengthBUOptimized(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0) return 0;

        int[][] dp = new int[2][B.length + 1];

        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                }
                max = Math.max(max, dp[i % 2][j]);
            }
        }

        return max;
    }

    /**
     * Time O(a * b)
     * Space O(b)
     */
    public int findLengthBUOptimizedOn(int[] a, int[] b) {
        int m = a.length, n = b.length;
        if (m == 0 || n == 0) return 0;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j] = a[i] == b[j] ? 1 + dp[j + 1] : 0);
            }
        return max;
    }
}
