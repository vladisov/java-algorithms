package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * https://leetcode.com/contest/biweekly-contest-42/problems/maximum-binary-string-after-change/
 */
public class MaximumBinaryString {

    /**
     * Time O(N)
     * SpaceO (N) ?
     */
    public String maximumBinaryString(String binary) {
        char[] chs = binary.toCharArray();
        int ones = 0, zeros = 0, onesBefore = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '1') {
                ones++;
                if (zeros == 0) onesBefore++;
            } else zeros++;
        }
        if (zeros <= 1) return binary;
        for (int i = 0; i < chs.length; i++) {
            if (onesBefore > 0) {
                chs[i] = '1';
                onesBefore--;
                ones--;
            } else if (zeros > 0) {
                chs[i] = '0';
                zeros--;
            } else {
                chs[i] = '1';
                ones--;
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (i < chs.length - 1 && chs[i] == '0' && chs[i + 1] == '0') {
                chs[i] = '1';
            }
        }
        return new String(chs);
    }
}
