package dev.algos.snatch.interview_problems.dp;

/**
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * <p>
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class OnesAndZeros {

    /**
     * Recursion memoization approach
     * Time and Space O(l * n * m)
     */
    public int findMaxFormBruteForceDP(String[] strs, int m, int n) {
        Integer dp[][][] = new Integer[strs.length + 1][m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            int[] counts = countOnesAndZeros(strs[i - 1]);
            for (int zeros = 0; zeros <= m; zeros++) {
                for (int ones = 0; ones <= n; ones++) {
                    dp[i][zeros][ones] = 0;
                    if (zeros - counts[0] >= 0 && ones - counts[1] >= 0) {
                        dp[i][zeros][ones] = 1 + dp[i - 1][zeros - counts[0]][ones - counts[1]];
                    } else {
                        dp[i][zeros][ones] = dp[i - 1][zeros][ones];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private int findMaxFormRecMemo1(String[] strs, int zeros, int ones, Integer[][][] dp, int i) {
        if (i >= strs.length) {
            return 0;
        }
        if (dp[i][zeros][ones] != null) {
            return dp[i][zeros][ones];
        }
        int[] counts = countOnesAndZeros(strs[i]);
        int taken = 0;
        if (zeros - counts[0] >= 0 && ones - counts[1] >= 0) {
            taken = findMaxFormRec(strs, zeros - counts[0], ones - counts[1], i + 1) + 1;
        }
        int notTaken = findMaxFormRec(strs, zeros, ones, i + 1);
        dp[i][zeros][ones] = Math.max(taken, notTaken);
        return dp[i][zeros][ones];
    }

    /**
     * Recursion memoization approach
     * Time and Space O(l * n * m)
     */
    public int findMaxFormBruteForceRecMemo(String[] strs, int m, int n) {
        Integer dp[][][] = new Integer[strs.length][m + 1][n + 1];
        return findMaxFormRec(strs, m, n, 0);
    }

    private int findMaxFormRecMemo(String[] strs, int zeros, int ones, Integer[][][] dp, int i) {
        if (i >= strs.length) {
            return 0;
        }
        if (dp[i][zeros][ones] != null) {
            return dp[i][zeros][ones];
        }
        int[] counts = countOnesAndZeros(strs[i]);
        int taken = 0;
        if (zeros - counts[0] >= 0 && ones - counts[1] >= 0) {
            taken = findMaxFormRec(strs, zeros - counts[0], ones - counts[1], i + 1) + 1;
        }
        int notTaken = findMaxFormRec(strs, zeros, ones, i + 1);
        dp[i][zeros][ones] = Math.max(taken, notTaken);
        return dp[i][zeros][ones];
    }

    /**
     * Recursion approach
     * TLE
     */
    public int findMaxFormBruteForceRec(String[] strs, int m, int n) {
        return findMaxFormRec(strs, m, n, 0);
    }

    private int findMaxFormRec(String[] strs, int zeros, int ones, int i) {
        if (i >= strs.length) {
            return 0;
        }
        int[] counts = countOnesAndZeros(strs[i]);
        int taken = 0;
        if (zeros - counts[0] >= 0 && ones - counts[1] >= 0) {
            taken = findMaxFormRec(strs, zeros - counts[0], ones - counts[1], i + 1) + 1;
        }
        int notTaken = findMaxFormRec(strs, zeros, ones, i + 1);
        return Math.max(taken, notTaken);
    }

    private int[] countOnesAndZeros(String str) {
        int[] count = new int[2];
        for (char c : str.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}
