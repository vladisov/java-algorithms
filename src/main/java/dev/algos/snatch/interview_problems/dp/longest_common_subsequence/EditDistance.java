package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting,
 * inserting, or replacing characters. Write a function to calculate the count of the minimum number of edit operations.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "bat"
 * s2 = "but"
 * Output: 1
 * Explanation: We just need to replace 'a' with 'u' to transform s1 to s2.
 * Example 2:
 * <p>
 * Input: s1 = "abdca"
 * s2 = "cbda"
 * Output: 2
 * Explanation: We can replace first 'a' with 'c' and delete second 'c'.
 * Example 3:
 * <p>
 * Input: s1 = "passpot"
 * s2 = "passpot"
 * Output: 3
 * Explanation: Replace 'a' with 'p', 'o' with 'q', and insert 'r'.
 */
public class EditDistance {

    /**
     * Time and space O(n * m)
     */
    int minDistanceBU(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return s2.length();
        if (s2 == null || s2.length() == 0) return s1.length();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int c1 = 1 + dp[i][j - 1];
                    int c2 = 1 + dp[i - 1][j];
                    int c3 = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(c3, Math.min(c1, c2));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    int findEditDistance(String s1, String s2) {
        if (s1 == null || s1.length() == 0) return s2.length();
        if (s2 == null || s2.length() == 0) return s1.length();

        Integer[][] dp = new Integer[s1.length()][s2.length()];
        return findEditDistanceRec(s1, s2, 0, 0, dp);
    }

    private int findEditDistanceRec(String s1, String s2, int i, int j, Integer[][] dp) {
        if (i >= s1.length() && j > s2.length()) {
            return 0;
        }
        if (j >= s2.length()) {
            return s1.length() - i;
        }
        if (i >= s1.length()) {
            return s2.length() - j;
        }

        if (dp[i][j] == null) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = findEditDistanceRec(s1, s2, i + 1, j + 1, dp);
                return dp[i][j];
            }
            int c1 = 1 + findEditDistanceRec(s1, s2, i, j + 1, dp);
            int c2 = 1 + findEditDistanceRec(s1, s2, i + 1, j, dp);
            int c3 = 1 + findEditDistanceRec(s1, s2, i + 1, j + 1, dp);
            dp[i][j] = Math.min(Math.min(c1, c2), c3);
        }
        return dp[i][j];
    }
}
