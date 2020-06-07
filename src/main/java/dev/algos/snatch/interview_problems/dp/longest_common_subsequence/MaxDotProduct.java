package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given two arrays nums1 and nums2.
 * <p>
 * Return the maximum dot product between non-empty subsequences of nums1 and nums2 with the same length.
 * <p>
 * A subsequence of a array is a new array which is formed from the original array by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, [2,3,5] is a subsequence of [1,2,3,4,5] while [1,5,3] is not).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
 * Output: 18
 * Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
 * Their dot product is (2*3 + (-2)*(-6)) = 18.
 */
public class MaxDotProduct {

    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][][] dp = new Integer[nums1.length][nums2.length][2];
        return maxDotProductRec(nums1, nums2, 0, 0, 0, dp);
    }

    public int maxDotProductRec(int[] nums1, int[] nums2, int i, int j, int taken, Integer[][][] dp) {
        if (i == nums1.length || j == nums2.length) {
            return taken == 1 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[i][j][taken] == null) {
            int product = nums1[i] * nums2[j];
            int p1 = product + maxDotProductRec(nums1, nums2, i + 1, j + 1, 1, dp);
            int p2 = maxDotProductRec(nums1, nums2, i, j + 1, taken, dp);
            int p3 = maxDotProductRec(nums1, nums2, i + 1, j, taken, dp);
            int p4 = maxDotProductRec(nums1, nums2, i + 1, j + 1, taken, dp);
            dp[i][j][taken] = Math.max(Math.max(p1, p2), Math.max(p3, p4));
        }
        return dp[i][j][taken];
    }

    /**
     * Time O(N*M)
     * Space O(N*M)
     */
    public int maxDotProductDP(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = nums1[i] * nums2[j];
                dp[i][j] += i > 0 && j > 0 ? Math.max(0, dp[i - 1][j - 1]) : 0;
                dp[i][j] = i > 0 ? Math.max(dp[i - 1][j], dp[i][j]) : dp[i][j];
                dp[i][j] = j > 0 ? Math.max(dp[i][j - 1], dp[i][j]) : dp[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }
}
