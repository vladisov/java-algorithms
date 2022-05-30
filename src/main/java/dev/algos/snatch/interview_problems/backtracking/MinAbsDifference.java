package dev.algos.snatch.interview_problems.backtracking;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/closest-subsequence-sum/
 */
public class MinAbsDifference {

    /**
     * Time O(2^(N/2) * log(2^(N/2))
     * Space O(2^N/2)
     * <p>
     * https://www.quora.com/What-is-meet-in-the-middle-algorithm-w-r-t-competitive-programming/answer/S-A-Kumar-3?ch=10&share=6cf3632a&srid=ONoNp
     */
    public int minAbsDifference(int[] nums, int goal) {
        TreeSet<Integer> first = new TreeSet<>();
        TreeSet<Integer> second = new TreeSet<>();
        generate(nums, 0, 0, (nums.length) / 2, first);
        generate(nums, 0, (nums.length) / 2 + 1, nums.length - 1, second);
        int ans = Integer.MAX_VALUE;
        for (int num : first) {
            int diff = goal - num;
            if (diff == 0) return 0;
            int left = second.floor(diff) == null ? 0 : second.floor(diff);
            int right = second.ceiling(diff) == null ? 0 : second.ceiling(diff);
            ans = Math.min(ans, Math.min(Math.abs(num + left - goal), Math.abs(num + right - goal)));
        }
        return ans;
    }

    void generate(int[] nums, int sum, int start, int end, TreeSet<Integer> set) {
        set.add(sum);
        if (start > end) return;
        generate(nums, sum, start + 1, end, set);
        generate(nums, sum + nums[start], start + 1, end, set);
    }
}
