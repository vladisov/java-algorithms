package dev.algos.snatch.interview_problems.gss;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(nums[i], 0);
        }
        return new int[]{-1, -1};
    }
}
