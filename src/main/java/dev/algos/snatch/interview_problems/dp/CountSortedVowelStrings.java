package dev.algos.snatch.interview_problems.dp;

public class CountSortedVowelStrings {

    public int countVowelStrings(int n) {
        return helper(0, 0, n, new int[n][5]);
    }

    int helper(int start, int index, int n, int[][] dp) {
        if (index == n) return 1;
        if (dp[index][start] == 0) {
            int ans = 0;
            for (int i = start; i < 5; i++) {
                ans += helper(i, index + 1, n, dp);
            }
            dp[index][start] = ans;
        }
        return dp[index][start];
    }

    /*
      1 2 3 4 5
    1 1
    2

     */

    public int countVowelStringsBU(int n) {
        int[][] dp = new int[n][5];
        dp[0][0] = 5;
        for (int i = 5; i >= 0; i--) dp[0][i] = i;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = dp[i - 1][j] + j > 0 ? dp[i][j - 1] : 0;
            }
        }
        return dp[n - 1][4];
    }

    public int countVowelStringsOptimized(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while (n > 1) {
            // add new char before prev string
            a = (a + e + i + o + u); // a, e, i, o, u -> aa, ae, ai, ao, au
            e = (e + i + o + u); // e, i, o, u -> ee, ei, eo, eu
            i = (i + o + u); // i, o, u -> ii, io, iu
            o = (o + u); // o, u -> oo, ou
            u = (u);
            ; // u -> uu
            n--;
        }
        return a + e + i + o + u;
    }

}
