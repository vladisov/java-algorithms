package dev.algos.snatch.interview_problems.two_pointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible,
 * return the sum of the triplet. If there are more than one such triplet,
 * return the sum of the triplet with the smallest sum.
 * <p>
 * Example 1:
 * <p>
 * Input: [-2, 0, 1, 2], target=2
 * Output: 1
 * Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
 * Example 2:
 * <p>
 * Input: [-3, -1, 1, 2], target=1
 * Output: 0
 * Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
 * Example 3:
 * <p>
 * Input: [1, 0, 1, 1], target=100
 * Output: 3
 * Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */
public class ThreeSumCloseToTarget {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    int searchTriplet(int[] arr, int targetSum) {
        if (arr.length < 3) throw new IllegalArgumentException();
        Arrays.sort(arr);
        int minSum = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                int j = i + 1, k = arr.length - 1;
                while (j < k) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (Math.abs(targetSum - sum) < Math.abs(targetSum - minSum)) {
                        minSum = sum;
                    }
                    if (sum < targetSum) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return minSum;
    }

    int searchTriplet1(int[] arr, int targetSum) {
        Arrays.sort(arr);
        int smallestDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int diff = targetSum - arr[i] - arr[left] - arr[right];
                if (diff == 0) {
                    return targetSum;
                }
                if (Math.abs(diff) < Math.abs(smallestDiff)) {
                    smallestDiff = diff;
                }
                if (diff > 0) left++;
                if (diff < 0) right--;
            }
        }
        return targetSum - smallestDiff;
    }
}
