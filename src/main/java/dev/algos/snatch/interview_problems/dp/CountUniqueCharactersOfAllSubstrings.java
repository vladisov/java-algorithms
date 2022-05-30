package dev.algos.snatch.interview_problems.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
 */
public class CountUniqueCharactersOfAllSubstrings {

    /**
     * Time O(N)
     * Space O(N * 2)
     */
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        for (int i = 0; i < n; i++) {
            dp[i][0] = left[s.charAt(i) - 'A'];
            left[s.charAt(i) - 'A'] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = right[s.charAt(i) - 'A'];
            right[s.charAt(i) - 'A'] = i;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int leftIndex = dp[i][0];
            int rightIndex = dp[i][1];
            sum += (i - leftIndex) * (rightIndex - i); // XX(AXX)A count how many ways to make A unique
        }
        return sum;
    }
}
