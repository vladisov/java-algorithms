package dev.algos.snatch.interview_problems.array.two_pointers;

import java.util.Arrays;

/**
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 * <code>
 * arr[i] + arr[j] + arr[k] < target
 * </code>
 * where i, j, and k are three different indices. Write a function to return the count of such triplets.
 */
class TripletWithSmallerSum {

    int searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum < target) {
                    count+= right - left;
                    right--;
                }
                if (sum > target) {
                    left++;
                }
            }
        }
        return count;
    }
}
