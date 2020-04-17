package dev.algos.snatch.interview_problems.dp;

public class DecodeWays {


    /**
     * Time O(N)
     * Space O(N)
     */
    public int numDecodingsBU(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }


    /**
     * Time O(N)
     * Space O(N)
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Integer[] dp = new Integer[s.length()];

        return recursiveWithMemo(0, s, dp);
    }

    private int recursiveWithMemo(int index, String str, Integer[] dp) {
        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }
        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }
        if (index == str.length() - 1) {
            return 1;
        }
        // Memoization is needed since we might encounter the same sub-string.
        if (dp[index] != null) {
            return dp[index];
        }
        int ans = recursiveWithMemo(index + 1, str, dp);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
            ans += recursiveWithMemo(index + 2, str, dp);
        }
        // Save for memoization
        dp[index] = ans;
        return ans;
    }
}
