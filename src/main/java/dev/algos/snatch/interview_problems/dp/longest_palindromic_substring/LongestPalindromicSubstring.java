package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    /**
     * Time O(N^2)
     * Space O(1)
     */
    public String longestPalindromeExpand(String s) {
        if (s == null || s.length() <= 1) return s;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }


    int expandFromMiddle(String s, int start, int end) {
        if (s == null || start > end) return 0;

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String[][] dp = new String[s.length()][s.length()];
        return longestPalindromeRec(s, 0, s.length() - 1, "", dp);
    }

    String longestPalindromeRec(String s, int start, int end, String sub, String[][] dp) {
        if (start == end) {
            return String.valueOf(s.charAt(start));
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        String palindrome = getPalindrome(s, start, end);
        if (palindrome != null) {
            return palindrome;
        }

        String sub1 = longestPalindromeRec(s, start + 1, end, sub, dp);
        String sub2 = longestPalindromeRec(s, start, end - 1, sub, dp);
        sub = sub1.length() > sub2.length() ? sub1 : sub2;

        dp[start][end] = sub;
        return sub;
    }

    private String getPalindrome(String s, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return null;
            }
        }

        return s.substring(start, end + 1);
    }
}
