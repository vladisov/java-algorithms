package dev.algos.snatch.interview_problems.gss;

class ProductOfArrayExceptSelf {

    int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}
