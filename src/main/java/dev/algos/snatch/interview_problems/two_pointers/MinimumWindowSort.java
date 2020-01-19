package dev.algos.snatch.interview_problems.two_pointers;

/**
 * Given an array, find the length of the smallest subarray in it
 * which when sorted will sort the whole array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 5, 3, 7, 10, 9, 12]
 * Output: 5
 * Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
 * Example 2:
 * <p>
 * Input: [1, 3, 2, 0, -1, 7, 10]
 * Output: 5
 * Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
 * Example 3:
 * <p>
 * Input: [1, 2, 3]
 * Output: 0
 * Explanation: The array is already sorted
 * Example 4:
 * <p>
 * Input: [3, 2, 1]
 * Output: 3
 * Explanation: The whole array needs to be sorted.
 */
public class MinimumWindowSort {


    int sort(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }

        int lo = 0, hi = arr.length - 1;

        while (lo < arr.length - 1 && arr[lo] <= arr[lo + 1]) {
            lo++;
        }

        if (lo == arr.length - 1) {
            return 0;
        }

        while (hi > 0 && arr[hi] >= arr[hi - 1]) {
            hi--;
        }

        int subarrayMin = arr[lo], subarrayMax = arr[lo];
        for (int i = lo; i <= hi; i++) {
            subarrayMin = Math.min(subarrayMin, arr[i]);
            subarrayMax = Math.max(subarrayMax, arr[i]);
        }

        while (lo > 0 && arr[lo - 1] > subarrayMin) lo--;
        while (hi < arr.length - 1 && arr[hi + 1] < subarrayMax) hi++;

        return hi - lo + 1;
    }
}
