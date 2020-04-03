package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string, find the minimum number of characters that we can remove to make it a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "abdbca"
 * Output: 1
 * Explanation: By removing "c", we get a palindrome "abdba".
 * Example 2:
 * <p>
 * Input: = "cddpd"
 * Output: 2
 * Explanation: Deleting "cp", we get a palindrome "ddd".
 * Example 3:
 * <p>
 * Input: = "pqr"
 * Output: 2
 * Explanation: We have to remove any two characters to get a palindrome, e.g. if we
 * remove "pq", we get palindrome "r".
 */
public class MinimumDeletionsStringToMakeItPalindrome {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    int minDeletions2(String str) {
        return str.length() - findLPSLengthBU(str);
    }

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
    int minDeletions(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        Integer[][] dp = new Integer[n][n];
        return minDeletions(str, 0, n - 1, n, dp);
    }

    int minDeletions(String s, int start, int end, int len, Integer[][] dp) {
        if (start > end) return 0;

        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = minDeletions(s, start + 1, end - 1, len - 2, dp);
                return dp[start][end];
            }

            int min1 = 1 + minDeletions(s, start + 1, end, len - 1, dp);
            int min2 = 1 + minDeletions(s, start, end - 1, len - 1, dp);
            dp[start][end] = Math.min(min1, min2);
        }
        return dp[start][end];
    }
}
