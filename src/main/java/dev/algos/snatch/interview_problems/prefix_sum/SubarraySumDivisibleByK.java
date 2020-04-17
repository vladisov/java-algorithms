package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class SubarraySumDivisibleByK {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int subarraysDivByK(int[] nums, int k) {
        int result = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // we've seen sum 0 - once
        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) sum += k; //choose mod on positive side
            //if we already have seen mod like current then subarray sum is divisible by k
            if (map.containsKey(sum)) {
                result += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
