package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Problem Statement #
 * Given a sequence, find the length of its longest repeating subsequence (LRS).
 * A repeating subsequence will be the one that appears at least twice in the original sequence and is
 * not overlapping (i.e. none of the corresponding characters in the repeating subsequences have the same index).
 * <p>
 * Example 1:
 * <p>
 * Input: “t o m o r r o w”
 * Output: 2
 * Explanation: The longest repeating subsequence is “or” {tomorrow}.
 * <p>
 * Example 2:
 * <p>
 * Input: “a a b d b c e c”
 * Output: 3
 * Explanation: The longest repeating subsequence is “a b c” {a a b d b c e c}.
 * <p>
 * Example 3:
 * <p>
 * Input: “f m f f”
 * Output: 2
 * Explanation: The longest repeating subsequence is “f f” {f m f f, f m f f}. Please note the second last character is shared in LRS.
 */
public class LongestRepeatingSubsequence {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int longestRepeatingBU(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int longestRepeating(String s) {
        Integer[][] dp = new Integer[s.length()][s.length()];
        return longestRepeatingRec(s, 0, 0, dp);
    }

    private int longestRepeatingRec(String s, int i, int j, Integer[][] dp) {
        if (i >= s.length() || j >= s.length()) return 0;

        if (dp[i][j] == null) {
            if (i != j && s.charAt(i) == s.charAt(j)) {
                return 1 + longestRepeatingRec(s, i + 1, j + 1, dp);
            }
            int len1 = longestRepeatingRec(s, i, j + 1, dp);
            int len2 = longestRepeatingRec(s, i + 1, j, dp);
            dp[i][j] = Math.max(len1, len2);
        }
        return dp[i][j];
    }
}
