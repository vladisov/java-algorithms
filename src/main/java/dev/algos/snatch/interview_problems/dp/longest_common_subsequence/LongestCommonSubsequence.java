package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not).
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * If there is no common subsequence, return 0.
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequenceBUOptimized(String text1, String text2) {
        if (text2.length() < text1.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int[][] dp = new int[2][text2.length() + 1];

        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
                }
                max = Math.max(dp[i % 2][j], max);
            }
        }
        return max;
    }


    /**
     * Time O(N * M)
     * Space O(N * M)
     */
    public int longestCommonSubsequenceDiscuss(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length(); ++i)
            for (int j = 0; j < s2.length(); ++j)
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
        return dp[s1.length()][s2.length()];
    }

    /**
     * Time O(N * M)
     * Space O(N * M)
     */
    public int longestCommonSubsequenceBU(String text1, String text2) {
        if (text2.length() < text1.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int max = 0;
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
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
     * Time O(N * M)
     * Space O(N * M)
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text2.length() < text1.length()) {
            return longestCommonSubsequence(text2, text1);
        }
        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequenceRec(text1, text2, 0, 0, dp);
    }

    private int longestCommonSubsequenceRec(String text1, String text2, int i, int j, Integer[][] dp) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (dp[i][j] == null) {
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + longestCommonSubsequenceRec(text1, text2, i + 1, j + 1, dp);
                return dp[i][j];
            }

            int len1 = longestCommonSubsequenceRec(text1, text2, i + 1, j, dp);
            int len2 = longestCommonSubsequenceRec(text1, text2, i, j + 1, dp);
            dp[i][j] = Math.max(len1, len2);
        }
        return dp[i][j];
    }
}
