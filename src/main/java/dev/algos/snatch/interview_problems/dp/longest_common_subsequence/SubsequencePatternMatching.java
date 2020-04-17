package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given a string and a pattern, write a method to count the number of times the pattern appears in the string as a subsequence.
 * <p>
 * Example 1: Input: string: “baxmx”, pattern: “ax”
 * Output: 2
 * Explanation: {baxmx, baxmx}.
 * <p>
 * Example 2:
 * <p>
 * Input: string: “tomorrow”, pattern: “tor”
 * Output: 4
 * Explanation: Following are the four occurences: {tomorrow, tomorrow, tomorrow, tomorrow}.
 */
public class SubsequencePatternMatching {

    /**
     * Time O(s * p)
     * Space O(s * p)
     */
    int countPatternBU(String s, String pattern) {
        int[][] dp = new int[s.length() + 1][pattern.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][pattern.length()];
    }

    int countPattern(String s, String pattern) {
        Integer[][] dp = new Integer[s.length()][pattern.length()];
        return countPatternRec(s, pattern, 0, 0, dp);
    }

    private int countPatternRec(String s, String p, int i, int j, Integer[][] dp) {
        if (j >= p.length()) {
            return 1;
        }
        if (i >= s.length()) {
            return 0;
        }

        if (dp[i][j] == null) {
            int c1 = 0;
            if (s.charAt(i) == p.charAt(j)) {
                c1 = countPatternRec(s, p, i + 1, j + 1, dp);
            }
            int c2 = countPatternRec(s, p, i + 1, j, dp);
            dp[i][j] = c1 + c2;
        }
        return dp[i][j];
    }
}
