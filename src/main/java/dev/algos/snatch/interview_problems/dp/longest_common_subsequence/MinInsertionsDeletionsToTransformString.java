package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Problem Statement #
 * Given strings s1 and s2, we need to transform s1 into s2 by deleting and inserting characters. Write a function to calculate the count of the minimum number of deletion and insertion operations.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "abc"
 * s2 = "fbc"
 * Output: 1 deletion and 1 insertion.
 * Explanation: We need to delete {'a'} and insert {'f'} to s1 to transform it into s2.
 * Example 2:
 * <p>
 * Input: s1 = "abdca"
 * s2 = "cbda"
 * Output: 2 deletions and 1 insertion.
 * Explanation: We need to delete {'a', 'c'} and insert {'c'} to s1 to transform it into s2.
 * Example 3:
 * <p>
 * Input: s1 = "passport"
 * s2 = "ppsspt"
 * Output: 3 deletions and 1 insertion
 * Explanation: We need to delete {'a', 'o', 'r'} and insert {'p'} to s1 to transform it into s2.
 */
public class MinInsertionsDeletionsToTransformString {

    /**
     * Time O(n * m)
     * Space O(n * m)
     */
    public void findMDI(String s1, String s2) {
        int c1 = findLCSLength(s1, s2);
        System.out.println("Minimum deletions needed: " + (s1.length() - c1));
        System.out.println("Minimum insertions needed: " + (s2.length() - c1));
    }

    private int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() + word2.length() - lcs * 2;
    }

    public int lcs(String text1, String text2) {
        if (text2.length() < text1.length()) {
            return lcs(text2, text1);
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
}
