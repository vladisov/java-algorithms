package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Problem Statement #
 * Given a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Example 1:
 * <p>
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 * Example 2:
 * <p>
 * Input: {1, 1, 3, 4, 7}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
 * Example 3:
 * <p>
 * Input: {2, 3, 4, 6}
 * Output: False
 * Explanation: The given set cannot be partitioned into two subsets with equal sum.
 */
public class CanPartitionSum {

    /**
     * Time complexity O(N * S) n - numbers s - sum of numbers
     * Space complexity O(N * S)
     */
    public boolean canPartition(int[] num) {
        int sum = 0;
        for (int value : num) sum += value;

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
        return this.canPartitionRecursive(dp, num, sum / 2, 0);
    }

    private boolean canPartitionRecursive(Boolean[][] dp, int[] num, int sum, int currentIndex) {
        // base check
        if (sum == 0)
            return true;

        if (num.length == 0 || currentIndex >= num.length)
            return false;

        // if we have not already processed a similar problem
        if (dp[currentIndex][sum] == null) {
            // recursive call after choosing the number at the currentIndex
            // if the number at currentIndex exceeds the sum, we shouldn't process this
            if (num[currentIndex] <= sum) {
                if (canPartitionRecursive(dp, num, sum - num[currentIndex], currentIndex + 1)) {
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            // recursive call after excluding the number at the currentIndex
            dp[currentIndex][sum] = canPartitionRecursive(dp, num, sum, currentIndex + 1);
        }

        return dp[currentIndex][sum];
    }

    public boolean canPartitionDpBruteForce(int[] num) {
        int sum = 0;
        for (int value : num) sum += value;
        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;


        Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];

        for (int i = 0; i < num.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < sum / 2 + 1; i++) {
            dp[0][i] = true;
        }


        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (num[i] <= sum) {
                    boolean left = false;
                    if (j >= num[i]) {
                        left = dp[i][j] = dp[i - 1][j - num[i]];
                    }
                    boolean right = dp[i - 1][j];
                    dp[i][j] = right || left;
                }
            }
        }

        return dp[num.length - 1][sum / 2 + 1];
    }

    /**
     * Time complexity O(N * S) n - numbers s - sum of numbers
     * Space complexity O(N * S)
     */
    public boolean canPartitionDp(int[] num) {
        int sum = 0;
        for (int value : num) sum += value;
        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if (sum % 2 != 0)
            return false;

        Boolean[] dp = new Boolean[sum / 2 + 1];
        for (int i = 0; i < sum / 2 + 1; i++) {
            dp[i] = num[0] == i;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = sum / 2; j > 0; j--) {
                if (num[i] <= j) {
                    dp[j] = dp[j - num[i]] || dp[j];
                }
            }
        }
        return dp[sum / 2];
    }

    /**
     * Kotlin version
     */
//    fun canPartition(nums: IntArray): Boolean {
//        var sum = nums.sum()
//        if (sum % 2 != 0) return false
//        sum /= 2
//        var prev = BooleanArray(sum + 1)
//        prev[0] = true
//        for (i in nums.size - 2 downTo 0) {
//            val curr = BooleanArray(sum + 1)
//            for (s in 0..sum) {
//                val skip = prev[s]
//                val take = if (s - nums[i] >= 0) prev[s - nums[i]] else false
//                if (skip || take) {
//                    curr[s] = true
//                }
//            }
//            prev = curr
//        }
//        return prev[sum]
//    }
}
