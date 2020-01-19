package dev.algos.snatch.interview_problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers,
 * find all unique triplets in it that add up to zero.
 */
class TripletSumToZero {

    List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] == arr[i + 1]) {
                continue;
            }
            int left = i + 1;
            int right = arr.length - 1;
            int targetSum = -(arr[i]);
            while (left < right) {
                int currentSum = arr[left] + arr[right];
                if (currentSum == targetSum) {
                    triplets.add(List.of(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while (left < right && arr[left] == arr[left - 1]) {
                        left++;
                    }
                    while (left < right && arr[right] == arr[right + 1]) {
                        right--;
                    }
                }
                if (currentSum < targetSum) {
                    left++;
                }
                if (currentSum > targetSum) {
                    right--;
                }
            }
        }
        return triplets;
    }
}

