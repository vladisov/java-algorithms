package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromicPartitioning2 {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int minCutBU(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || isPalindrome[start + 1][end - 1]) {
                        isPalindrome[start][end] = true;
                    }
                }
            }
        }

        int[] cuts = new int[n];
        for (int start = n - 1; start >= 0; start--) {
            int min = n;
            for (int end = n - 1; end >= start; end--) {
                if (isPalindrome[start][end]) {
                    min = end == n - 1 ? 0 : Math.min(min, 1 + cuts[end + 1]);
                }
            }
            cuts[start] = min;
        }
        return cuts[0];
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        Integer[][] dp = new Integer[s.length()][s.length()];
        return minCutRec(s, 0, s.length() - 1, dp);
    }

    /**
     * Time O(N^2) ???
     * Space O(N^2)
     */
    int minCutRec(String s, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] == null) {
            if (isPalindrome(s, start, end)) {
                dp[start][end] = 0;
                return 0;
            }

            int min = end - start;
            for (int i = start; i <= end; i++) {
                if (isPalindrome(s, start, i)) {
                    min = Math.min(min, 1 + minCutRec(s, i + 1, end, dp));
                }
            }
            dp[start][end] = min;
        }
        return dp[start][end];
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }

        }
        return true;
    }
}
