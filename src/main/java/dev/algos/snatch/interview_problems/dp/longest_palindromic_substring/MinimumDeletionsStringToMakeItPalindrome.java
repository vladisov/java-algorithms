package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

/**
 * Given a string, find the minimum number of characters that we can remove to make it a palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "abdbca"
 * Output: 1
 * Explanation: By removing "c", we get a palindrome "abdba".
 * Example 2:
 * <p>
 * Input: = "cddpd"
 * Output: 2
 * Explanation: Deleting "cp", we get a palindrome "ddd".
 * Example 3:
 * <p>
 * Input: = "pqr"
 * Output: 2
 * Explanation: We have to remove any two characters to get a palindrome, e.g. if we
 * remove "pq", we get palindrome "r".
 */
public class MinimumDeletionsStringToMakeItPalindrome {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    int minDeletions2(String str) {
        return str.length() - findLPSLength(str);
    }

    public int findLPSLength(String st) {
        // dp[i][j] stores the length of LPS from index 'i' to index 'j'
        int[][] dp = new int[st.length()][st.length()];

        // every sequence with one element is a palindrome of length 1
        for (int i = 0; i < st.length(); i++)
            dp[i][i] = 1;

        for (int startIndex = st.length() - 1; startIndex >= 0; startIndex--) {
            for (int endIndex = startIndex + 1; endIndex < st.length(); endIndex++) {
                // case 1: elements at the beginning and the end are the same
                if (st.charAt(startIndex) == st.charAt(endIndex)) {
                    dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
                } else { // case 2: skip one element either from the beginning or the end
                    dp[startIndex][endIndex] = Math.max(dp[startIndex + 1][endIndex], dp[startIndex][endIndex - 1]);
                }
            }
        }
        return dp[0][st.length() - 1];
    }


    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    int minDeletions(String str) {
        if (str == null || str.length() == 0) return 0;
        int n = str.length();
        Integer[][] dp = new Integer[n][n];
        return minDeletions(str, 0, n - 1, n, dp);
    }

    int minDeletions(String s, int start, int end, int len, Integer[][] dp) {
        if (start > end) return 0;

        if (dp[start][end] == null) {
            if (s.charAt(start) == s.charAt(end)) {
                dp[start][end] = minDeletions(s, start + 1, end - 1, len - 2, dp);
                return dp[start][end];
            }

            int min1 = 1 + minDeletions(s, start + 1, end, len - 1, dp);
            int min2 = 1 + minDeletions(s, start, end - 1, len - 1, dp);
            dp[start][end] = Math.min(min1, min2);
        }
        return dp[start][end];
    }
}
