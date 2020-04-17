package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

public class LongestCommonSubstringTwoStrings {

    public int findLengthBU(String a, String b) {
        if (a.length() == 0 || b.length() == 0) return 0;

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        int max = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == a.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

    /**
     * Time O(a * b)
     * Space O(a * b)
     */
    public int findLengthBUOptimized(String a, String b) {
        if (b.length() == 0 || a.length() == 0) return 0;

        int[][] dp = new int[2][b.length() + 1];

        int max = 0;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i % 2][j] = 1 + dp[(i - 1) % 2][j - 1];
                }
                max = Math.max(max, dp[i % 2][j]);
            }
        }

        return max;
    }
}
