package dev.algos.snatch.interview_problems.dp;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlices_II {

    /**
     * Time O(N^2)
     * Space O(N*diffs)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Long>[] dp = new Map[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                long c1 = dp[j].getOrDefault(diff, 0L);
                long c2 = dp[i].getOrDefault(diff, 0L);
                dp[i].put(diff, c1 + c2 + 1);
                res += c1;
            }
        }
        return res;
    }
}
