package dev.algos.snatch.interview_problems.gss;

class MaximumProductSubarray {

    int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int[] max = new int[nums.length]; max[0] = nums[0];
        int[] min = new int[nums.length]; min[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            res = Math.max(max[i], res);
        }
        return res;
    }
}
