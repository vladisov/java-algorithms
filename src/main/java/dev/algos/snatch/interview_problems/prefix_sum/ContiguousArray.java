package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContiguousArray {

    /**
     * Time complexity O(n)
     * Space complexiy O(n)
     */
    public int findMaxLength(int[] nums) {
        // count - index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                len = Math.max(len, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return len;
    }
}
