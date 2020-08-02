package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Arrays;

/**
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.
 * <p>
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.
 * <p>
 * Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
 */
public class MaximumSumOfThreeSubarrays {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sumFirst = 0;
        for (int i = 0; i < k; i++) {
            sumFirst += nums[i];
        }
        int sumSecond = 0;
        for (int i = k; i < k * 2; i++) {
            sumSecond += nums[i];
        }
        int sumThird = 0;
        for (int i = k * 2; i < k * 3; i++) {
            sumThird += nums[i];
        }

        int bestSeqFirst = 0;
        int[] bestSeqSecond = {0, k};
        int[] bestSeqThird = {0, k, k * 2};

        int bestSumFirst = sumFirst;
        int bestSumSecond = sumFirst + sumSecond;
        int bestSumThird = sumFirst + sumSecond + sumThird;

        int indexFirst = 0, indexSecond = k, indexThird = k * 2;
        while (indexThird < nums.length - k) {
            sumFirst = sumFirst - nums[indexFirst] + nums[indexFirst + k];
            sumSecond = sumSecond - nums[indexSecond] + nums[indexSecond + k];
            sumThird = sumThird - nums[indexThird] + nums[indexThird + k];

            if (sumFirst > bestSumFirst) {
                bestSumFirst = sumFirst;
                bestSeqFirst = indexFirst + 1;
            }

            if (bestSumFirst + sumSecond > bestSumSecond) {
                bestSumSecond = sumSecond + bestSumFirst;
                bestSeqSecond[0] = bestSeqFirst;
                bestSeqSecond[1] = indexSecond + 1;
            }

            if (bestSumSecond + sumThird > bestSumThird) {
                bestSumThird = sumThird + bestSumSecond;
                bestSeqThird[0] = bestSeqSecond[0];
                bestSeqThird[1] = bestSeqSecond[1];
                bestSeqThird[2] = indexThird + 1;
            }

            indexFirst++;
            indexSecond++;
            indexThird++;
        }
        return bestSeqThird;
    }


    /**
     * Dp solution TLE
     * Time O(NK)
     * Space O(NK)
     */
    public int[] maxSumOfThreeSubarraysDp(int[] nums, int k) {
        var list = new int[3];
        Sum[][][] dp = new Sum[nums.length][k + 1][4];
        helper(nums, k, k, 3, 0, list, dp);
        return list;
    }

    int helper(int[] nums, int k, int taken, int arrs, int i, int[] list, Sum[][][] dp) {
        if (i == nums.length || taken == 0 && arrs == 1) {
            return 0;
        }

        if (dp[i][taken][arrs] != null) {
            for (int j = arrs; j > 0; j--) {
                list[3 - j] = dp[i][taken][arrs].arr[3 - j];
            }
            return dp[i][taken][arrs].sum;
        }
        if (taken == 0) {
            arrs--;
            taken = k;
        }

        int s1 = 0, s2 = 0;
        if (taken == k && nums.length - i > arrs * k - (k - taken)) {
            s1 = helper(nums, k, taken, arrs, i + 1, list, dp);
        }
        var copy = new int[3];
        if (taken > 0) {
            copy = Arrays.copyOfRange(list, 0, list.length);
            if (taken == k) {
                copy[3 - arrs] = i;
            }
            s2 = nums[i] + helper(nums, k, taken - 1, arrs, i + 1, copy, dp);
        }

        if (s1 > s2) {
            dp[i][taken][arrs] = new Sum(s1, list);
        } else {
            for (int j = 0; j < 3; j++) list[j] = copy[j];
            dp[i][taken][arrs] = new Sum(s2, copy);
        }
        return dp[i][taken][arrs].sum;
    }

    static class Sum {
        int sum;
        int[] arr;

        public Sum(int sum, int[] arr) {
            this.sum = sum;
            this.arr = arr;
        }
    }
}
