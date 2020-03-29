package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
 * <p>
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 * <p>
 * Input: {1, 2, 7, 1, 5}
 * Output: 0
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of number is '0'. Following are the two subsets: {1, 2, 5} & {7, 1}.
 * <p>
 * Example 3: #
 * Input: {1, 3, 100, 4}
 * Output: 92
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '92'. Here are the two subsets: {1, 3, 4} & {100}.
 */
public class MinimumSubsetsSumDifference {

    public int canPartition(int[] nums) {
        return canPartitionRec(nums, 0, 0, 0);
    }

    private int canPartitionRec(int[] nums, int i, int sum1, int sum2) {
        if (i >= nums.length) {
            return Math.abs(sum1 - sum2);
        }
        int diff1 = canPartitionRec(nums, i + 1, sum1 + nums[i], sum2);
        int diff2 = canPartitionRec(nums, i + 1, sum1, sum2 + nums[i]);
        return Math.min(diff1, diff2);
    }

    public int canPartitionMemo(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return canPartitionRecMemo(nums, 0, 0, 0, dp);
    }

    private int canPartitionRecMemo(int[] nums, int i, int sum1, int sum2, Integer[][] dp) {
        if (i >= nums.length) {
            return Math.abs(sum1 - sum2);
        }
        if (dp[i][sum1] == null) {
            int diff1 = canPartitionRec(nums, i + 1, sum1 + nums[i], sum2);
            int diff2 = canPartitionRec(nums, i + 1, sum1, sum2 + nums[i]);
            dp[i][sum1] = Math.min(diff1, diff2);

        }
        return dp[i][sum1];
    }

    public int canPartitionBottomUpBF(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        int sum = target;
        target /= 2;

        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int s = 0; s < target; s++) {
            if (s == nums[0]) {
                dp[0][s] = true;
            }
        }
        for (int i = 1; i < nums.length; i++) {
            for (int s = 1; s <= target; s++) {
                boolean left = false;
                if (s >= nums[i]) {
                    left = dp[i - 1][s - nums[i]];
                }
                boolean right = dp[i - 1][s];
                dp[i][s] = left || right;
            }
        }
        int diff = 0;
        for (int s = target; s >= 0; s--) {
            if (dp[nums.length - 1][s]) {
                int first = sum - s;
                return Math.abs(first - s);
            }
        }
        return diff;
    }
}
