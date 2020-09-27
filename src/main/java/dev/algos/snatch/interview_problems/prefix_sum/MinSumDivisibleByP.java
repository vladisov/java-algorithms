package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.
 * <p>
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 * <p>
 * A subarray is defined as a contiguous block of elements in the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,1,4,2], p = 6
 * Output: 1
 * Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
 * Example 2:
 * <p>
 * Input: nums = [6,3,5,2], p = 9
 * Output: 2
 * Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3], p = 3
 * Output: 0
 * Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.
 * Example 4:
 * <p>
 * Input: nums = [1,2,3], p = 7
 * Output: -1
 * Explanation: There is no way to remove a subarray in order to get a sum divisible by 7.
 * Example 5:
 * <p>
 * Input: nums = [1000000000,1000000000,1000000000], p = 3
 * Output: 0
 */
public class MinSumDivisibleByP {

        /*
    6,3,5,2
    p = 9

    6 + 3 + 5 + 2 = 16

    mod = 7

    (pre[n] - (pre[i]-pre[j])) % p = 0 ... (remove a subarray to make pre[n] divisible by p)
    => pre[n] % p = (pre[i]-pre[j]) % p ... ((a-b)%m = a%m - b%m)
    => pre[n] % p = pre[i]%p - pre[j]%p
    => pre[j]%p = pre[i]%p - pre[n]%p ... (same property used above)
    since RHS can be negative we make it positive modulus by adding p and taking modulus
    => pre[j]%p = (pre[i]%p - pre[n]%p + p) % p

    6 -> 0
    0 -> 1
    5 -> 2
    7 -> 3

    https://stackoverflow.com/questions/2215318/difference-between-modulus-implementation-in-python-vs-java
     */

    /**
     * Time O(N)
     * Space O(N)
     */
    public int minSubarray(int[] nums, int p) {
        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int preSum = 0, min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            preSum = (preSum + nums[i]) % p;
            map.put(preSum, i);
            int target = (preSum - remainder + p) % p;
            if (map.containsKey(target)) {
                min = Math.min(min, i - map.get(target));
            }
        }
        return min == nums.length ? -1 : min;
    }
}
