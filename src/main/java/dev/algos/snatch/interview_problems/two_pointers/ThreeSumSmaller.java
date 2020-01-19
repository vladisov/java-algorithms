package dev.algos.snatch.interview_problems.two_pointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum,
 * count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j,
 * and k are three different indices. Write a function to return the count of such triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 * Example 2:
 * <p>
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: 4
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class ThreeSumSmaller {

    /**
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    int searchTriplets(int[] arr, int target) {
        if (arr.length == 0) return 0;
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1, k = arr.length - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < target) {
                    // found the triplet
                    // since arr[k] >= arr[j], therefore,
                    // we can replace arr[k] by any number between
                    // k and j to get a sum less than the target sum
                    count += k - j;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
