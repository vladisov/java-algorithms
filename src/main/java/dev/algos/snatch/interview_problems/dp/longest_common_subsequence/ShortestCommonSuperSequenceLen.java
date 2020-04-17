package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given two sequences ‘s1’ and ‘s2’, write a method to find the length of the shortest sequence
 * which has ‘s1’ and ‘s2’ as subsequences.
 * <p>
 * Example 2:
 * <p>
 * Input: s1: "abcf" s2:"bdcf"
 * Output: 5
 * Explanation: The shortest common super-sequence (SCS) is "abdcf".
 * Example 2:
 * <p>
 * Input: s1: "dynamic" s2:"programming"
 * Output: 15
 * Explanation: The SCS is "dynprogrammicng".
 */
public class ShortestCommonSuperSequenceLen {

    /**
     * Time O(N * M)
     * Space O(N)
     */
    public int findSCSLengthBU(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        //fill first row and col with length for other string
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }

    public int findSCSLength(String s1, String s2) {
        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findSCSLengthRec(s1, s2, 0, 0, dp);
    }

    private int findSCSLengthRec(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() && j >= s2.length()) {
            return 0;
        }
        if (i >= s1.length()) {
            return s2.length() - j;
        }
        if (j >= s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] == null) {
            if (s1.charAt(i) == s2.charAt(j)) {
                return 1 + findSCSLengthRec(s1, s2, i + 1, j + 1, dp);
            }
            int len1 = 1 + findSCSLengthRec(s1, s2, i, j + 1, dp);
            int len2 = 1 + findSCSLengthRec(s1, s2, i + 1, j, dp);
            dp[i][j] = Math.min(len1, len2);
        }
        return dp[i][j];
    }
}
