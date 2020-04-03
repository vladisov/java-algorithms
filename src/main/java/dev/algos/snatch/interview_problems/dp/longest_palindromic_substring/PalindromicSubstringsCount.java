package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromicSubstringsCount {

    /**
     * Time O(N^2)
     * Space O(1)
     */
    int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandFromMiddle(s, i, i);
            count += expandFromMiddle(s, i, i + 1);
        }
        return count;
    }

    int expandFromMiddle(String s, int start, int end) {
        if (s == null || start > end) return 0;
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;

            count++;
        }
        return count;
    }

    /**
     * Time O(N^2)
     * Space O(1)
     */
    int countSubstringsDP(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();

        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int start = n - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        count++;
                        dp[start][end] = true;
                    }
                }
            }
        }
        return count;
    }
}
