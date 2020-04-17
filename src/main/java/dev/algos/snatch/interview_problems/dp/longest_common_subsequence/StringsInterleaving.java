package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 * <p>
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 */
public class StringsInterleaving {

    /**
     * Time O(n * m)
     * Space O(n * m)
     */
    public Boolean findSI(String s1, String s2, String s3) {
        // dp[mIndex][nIndex] will be storing the result of string interleaving
        // up to s3[0..mIndex+nIndex-1]
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        // for the empty pattern, we have one matching
        if (s1.length() + s2.length() != s3.length())
            return false;

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                // if 's1' and 's2' are empty, then 's3' must have been empty too.
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                    // if 's1' is empty, we need to check the interleaving with 's2' only
                else if (i == 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i][j - 1];
                    // if 's2' is empty, we need to check the interleaving with 's1' only
                else if (j == 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    dp[i][j] = dp[i - 1][j];
                else {
                    // if the letter of 's1' and 's3' match, we take whatever is matched till i-1
                    if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        dp[i][j] = dp[i - 1][j];
                    // if the letter of 's2' and 's3' match, we take whatever is matched till j-1 too
                    // note the '|=', this is required when we have common letters
                    if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1))
                        dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleaveBU(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), l = s3.length();
        if (n + m != l) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        int k = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean b1 = false, b2 = false;
                if (k < l && s1.charAt(i - 1) == s3.charAt(k)) {
                    b1 = dp[i][j - 1];
                }
                if (k < l && s2.charAt(j - 1) == s3.charAt(k)) {
                    b2 = dp[i - 1][j];
                }
                dp[i][j] = b1 || b2;
            }
        }

        return dp[n][m];
    }

    public Boolean findSIEducative(String m, String n, String p) {
        Map<String, Boolean> dp = new HashMap<>();
        return findSIRecursive(dp, m, n, p, 0, 0, 0);
    }

    private boolean findSIRecursive(Map<String, Boolean> dp, String m, String n, String p,
                                    int mIndex, int nIndex, int pIndex) {

        // if we have reached the end of the all the strings
        if (mIndex == m.length() && nIndex == n.length() && pIndex == p.length())
            return true;

        // if we have reached the end of 'p' but 'm' or 'n' still has some characters left
        if (pIndex == p.length())
            return false;

        String subProblemKey = mIndex + "-" + nIndex + "-" + pIndex;
        if (!dp.containsKey(subProblemKey)) {
            boolean b1 = false, b2 = false;
            if (mIndex < m.length() && m.charAt(mIndex) == p.charAt(pIndex))
                b1 = findSIRecursive(dp, m, n, p, mIndex + 1, nIndex, pIndex + 1);

            if (nIndex < n.length() && n.charAt(nIndex) == p.charAt(pIndex))
                b2 = findSIRecursive(dp, m, n, p, mIndex, nIndex + 1, pIndex + 1);

            dp.put(subProblemKey, b1 || b2);
        }

        return dp.get(subProblemKey);
    }

    /**
     * Top down memoization
     * Time & Space = O(N^3)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return isInterleave(s1, s2, s3, 0, 0, 0, dp);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][][] dp) {
        if (k >= s3.length() && i >= s1.length() && j >= s2.length()) {
            return true;
        }
        if ((i >= s1.length() && j >= s2.length()) || k >= s3.length()) {
            return false;
        }

        if (dp[i][j][k] == null) {
            if (j >= s2.length()) {
                if (s1.charAt(i) == s3.charAt(k)) {
                    dp[i][j][k] = isInterleave(s1, s2, s3, i + 1, j, k + 1, dp);
                } else {
                    dp[i][j][k] = false;
                }
                return dp[i][j][k];
            }

            if (i >= s1.length()) {
                if (s2.charAt(j) == s3.charAt(k)) {
                    dp[i][j][k] = isInterleave(s1, s2, s3, i, j + 1, k + 1, dp);
                } else {
                    dp[i][j][k] = false;
                }
                return dp[i][j][k];
            }

            boolean b1 = false;
            if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
                b1 = isInterleave(s1, s2, s3, i + 1, j, k + 1, dp) || isInterleave(s1, s2, s3, i, j + 1, k + 1, dp);
            }

            boolean b2;
            if (s1.charAt(i) == s3.charAt(k)) {
                b2 = isInterleave(s1, s2, s3, i + 1, j, k + 1, dp);
            } else if (s2.charAt(j) == s3.charAt(k)) {
                b2 = isInterleave(s1, s2, s3, i, j + 1, k + 1, dp);
            } else {
                b2 = false;
            }

            dp[i][j][k] = b1 || b2;
        }
        return dp[i][j][k];
    }
}
