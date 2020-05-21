package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

import java.util.HashMap;
import java.util.Map;

/**
 * 1278. Palindrome Partitioning III
 * Hard
 * <p>
 * 205
 * <p>
 * 3
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given a string s containing lowercase letters and an integer k. You need to :
 * <p>
 * First, change some characters of s to other lowercase English letters.
 * Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
 * Return the minimal number of characters that you need to change to divide the string.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", k = 2
 * Output: 1
 * Explanation: You can split the string into "ab" and "c", and change 1 character in "ab" to make it palindrome.
 * Example 2:
 * <p>
 * Input: s = "aabbc", k = 3
 * Output: 0
 * Explanation: You can split the string into "aa", "bb" and "c", all of them are palindrome.
 * Example 3:
 * <p>
 * Input: s = "leetcode", k = 8
 * Output: 0
 */
public class PalindromicPartitioning3 {

    /**
     * Time and Space O(K *N^2)
     */
    int numToPalindromeOptimized(String s, int k) {
        if (s.length() == 0) return 0;
        //stores the minimum changes required to convert a string starting from i to j into palindrome (i.e for k=1)
        int[][] toPal = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                toPal[i][j] = s.charAt(i) == s.charAt(j) ? toPal[i + 1][j - 1] : 1 + toPal[i + 1][j - 1];
            }
        }
        //min changes to divide the string into k palindromic substrings starting from 0th index to jth index.
        int[][] dp = new int[s.length()][k + 1];
        for (int i = 0; i < s.length(); i++) {
            // from 0 to i substring with k = 1, we check toPal from 0 to i
            dp[i][1] = toPal[0][i];
        }
        for (int i = 2; i <= k; i++) {
            for (int end = 1; end < s.length(); end++) {
                int min = s.length();
                for (int start = end - 1; start >= 0; start--) {
                    min = Math.min(min, dp[start][i - 1] + toPal[start + 1][end]);
                }
                dp[i][end] = min;
            }
        }
        return dp[s.length() - 1][k];
    }


    int numToPalindromeNaive(String s, int k) {
        if (s.length() == 0) return 0;
        Map<String, Integer> memo = new HashMap<>();
        return helper(s, k, memo);
    }

    int helper(String s, int k, Map<String, Integer> memo) {
        if (s.length() <= 1) return 0;
        String key = s + "_" + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (k == 1) {
            memo.put(key, numToPalindrome(s));
            return memo.get(key);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int num = numToPalindrome(s.substring(0, i));
            min = Math.min(num + helper(s.substring(i), k - 1, memo), min);
        }
        memo.put(key, min);
        return min;
    }


    int numToPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return 0;
        int i = 0, j = s.length() - 1;
        int count = 0;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                count++;
            }
        }
        return count;
    }

}
