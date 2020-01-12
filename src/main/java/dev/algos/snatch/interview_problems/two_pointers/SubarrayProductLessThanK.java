package dev.algos.snatch.interview_problems.two_pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array with positive numbers and a target number,
 * find all of its contiguous subarrays whose product is less than the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 5, 3, 10], target=30
 * Output: [2], [5], [2, 5], [3], [5, 3], [10]
 * Explanation: There are six contiguous subarrays whose product is less than the target.
 * Example 2:
 * <p>
 * Input: [8, 2, 6, 5], target=50
 * Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
 * Explanation: There are seven contiguous subarrays whose product is less than the target.
 */
public class SubarrayProductLessThanK {

    /**
     * Time complexity O(n^3)
     * Space complexity O(n^2)
     */
    List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        if (arr.length == 0) return subarrays;
        int product = 1;
        for (int end = 0, start = 0; end < arr.length; end++) {
            product *= arr[end];
            while (product >= target && start < arr.length) {
                product /= arr[start++];
            }
            List<Integer> tmp = new ArrayList<>();
            for (int i = end; i >= start; i--) {
                tmp.add(0, arr[i]);
                subarrays.add(new ArrayList<>(tmp));
            }
        }
        return subarrays;
    }
}
