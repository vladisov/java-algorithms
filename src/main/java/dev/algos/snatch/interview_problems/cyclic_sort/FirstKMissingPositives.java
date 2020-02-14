package dev.algos.snatch.interview_problems.cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

/**
 * Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, -1, 4, 5, 5], k=3
 * Output: [1, 2, 6]
 * Explanation: The smallest missing positive numbers are 1, 2 and 6.
 * Example 2:
 * <p>
 * Input: [2, 3, 4], k=3
 * Output: [1, 5, 6]
 * Explanation: The smallest missing positive numbers are 1, 5 and 6.
 * Example 3:
 * <p>
 * Input: [-2, -3, 4], k=2
 * Output: [1, 2]
 * Explanation: The smallest missing positive numbers are 1 and 2.
 */
public class FirstKMissingPositives {

    /**
     * Time complexity O(n + k)
     * Space complexity O(k)
     */
    public List<Integer> findNumbers(int[] nums, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            int j = nums[i] - 1;
            if (j < nums.length && j >= 0 && nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        Set<Integer> extraNumbers = new HashSet<>();
        for (int i = 0; i < nums.length && missingNumbers.size() < k; i++)
            if (nums[i] != i + 1) {
                missingNumbers.add(i + 1);
                extraNumbers.add(nums[i]);
            }

        // add the remaining missing numbers
        for (int i = 1; missingNumbers.size() < k; i++) {
            int candidateNumber = i + nums.length;
            // ignore if the array contains the candidate number
            if (!extraNumbers.contains(candidateNumber))
                missingNumbers.add(candidateNumber);
        }

        return missingNumbers;
    }
}
