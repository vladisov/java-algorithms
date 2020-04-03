package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string, find the length of its Longest Palindromic Substring (LPS).
 * In a palindromic string, elements read the same backward and forward.
 */
public class LongestPalindromicSubstringLength {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int findLPSLengthBU(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        for (int start = n - 1; start >= 0; start--) { // start from last index
            for (int end = start + 1; end < n; end++) { // add one element in time
                if (str.charAt(start) == str.charAt(end)) {
                    int remainingLen = end - start - 1;
                    if (remainingLen == 0 || dp[start + 1][end - 1]) { // start + 1 end - 1 -> nested substring
                        maxLen = Math.max(maxLen, end - start + 1);
                    }
                }
            }
        }
        return maxLen;
    }

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int findLPSLength(String str) {
        if (str == null || str.length() == 0) return 0;
        Integer[][] dp = new Integer[str.length()][str.length()];
        return findLPSLengthRec(str, 0, str.length() - 1, dp);
    }

    int findLPSLengthRec(String s, int start, int end, Integer[][] dp) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }

        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end)) {
                int remainingLen = end - start - 1;
                int len = findLPSLengthRec(s, start + 1, end - 1, dp);
                if (remainingLen == len) {
                    dp[start][end] = end - start + 1;
                    return dp[start][end];
                }
            }
            int len1 = findLPSLengthRec(s, start + 1, end, dp);
            int len2 = findLPSLengthRec(s, start, end - 1, dp);
            dp[start][end] = Math.max(len1, len2);
        }

        return dp[start][end];
    }
}
