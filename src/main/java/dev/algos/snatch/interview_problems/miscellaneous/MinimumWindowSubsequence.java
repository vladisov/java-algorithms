package dev.algos.snatch.interview_problems.miscellaneous;

public class MinimumWindowSubsequence {

    /**
     * Shrink IT!
     * Time O(N*N optimized)
     * Space O(1) wout substring
     */
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty()) return "";
        int n = s.length(), m = t.length(), sIndex = 0, max = s.length();
        String ans = "";
        while (sIndex < n) {
            int tIndex = 0;
            while (sIndex < n) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    tIndex++;
                }
                if (tIndex == m) break;
                sIndex++;
            }
            if (sIndex == n || tIndex < m) break;
            int end = sIndex;
            tIndex = m - 1;
            while (sIndex >= 0) {
                if (s.charAt(sIndex) == t.charAt(tIndex)) {
                    tIndex--;
                }
                if (tIndex == -1) break;
                sIndex--;
            }
            if (end - sIndex + 1 < max) {
                max = end - sIndex + 1;
                ans = s.substring(sIndex, end + 1);
            }
            sIndex++;
        }
        return ans;
    }
}
