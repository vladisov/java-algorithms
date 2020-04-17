package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

public class ShortestCommonSupersequence {

    public String shortestCommonSupersequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // we found lcs
        StringBuilder sb = new StringBuilder();
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0 ^ j < 0) { // only one string reaches left end.
                char c = i < 0 ? s2.charAt(j--) : s1.charAt(i--); // remaining chars in the other string.
                sb.append(c);
            } else if (s1.charAt(i) == s2.charAt(j)) { // common char in LCS.
                sb.append(s1.charAt(i)); // append the char of either s1 or s2.
                --i;
                --j;
            } else { // the char is not in LCS.
                //TODO pzdcT
                char c = dp[i][j + 1] > dp[i + 1][j] ? s1.charAt(i--) : s2.charAt(j--); // the char corresponding to larger dp value.
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    private String lcs(String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = "";
            }
        }

        String res = "";
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    if (dp[i][j - 1].length() > dp[i - 1][j].length()) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                if (dp[i][j].length() > res.length()) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
