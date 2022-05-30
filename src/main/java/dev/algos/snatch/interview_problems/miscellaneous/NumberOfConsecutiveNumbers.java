package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Arrays;

public class NumberOfConsecutiveNumbers {

    /**
     * Time O(NlogN)
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int cnt = 1;
        for (int coin : coins) {
            if (coin <= cnt) {
                cnt += coin; // we can make count if we've already made count >= coin
            }
        }
        return cnt;
    }
}
