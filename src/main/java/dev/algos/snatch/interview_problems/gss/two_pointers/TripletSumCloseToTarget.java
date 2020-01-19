package dev.algos.snatch.interview_problems.gss.two_pointers;

import java.util.Arrays;

/**
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 */
class TripletSumCloseToTarget {

    int searchTriplet(int[] arr, int targetSum) {
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
