package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input:
 * <p>
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * <p>
 * "cbbd"
 * Output:
 * 2
 */
public class LongestPalindromicSubsequence {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int longestPalindromeSubseqBU(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = 2 + dp[start + 1][end - 1];
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }


        return dp[0][n - 1];
    }


    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        Integer[][] dp = new Integer[s.length()][s.length()];
        return longestPalindromeSeqRec(s, 0, s.length() - 1, dp);
    }

    int longestPalindromeSeqRec(String s, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) { // if start and end are the same
            dp[start][end] = 2 + longestPalindromeSeqRec(s, start + 1, end - 1, dp);
            return dp[start][end];
        }

        int sub1 = longestPalindromeSeqRec(s, start + 1, end, dp);
        int sub2 = longestPalindromeSeqRec(s, start, end - 1, dp);

        dp[start][end] = Math.max(sub1, sub2);
        return dp[start][end];
    }
}
