package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array. Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [5, 6, 7, 8, 9], K = 3, X = 7
 * Output: [6, 7, 8]
 * Example 2:
 * <p>
 * Input: [2, 4, 5, 6, 9], K = 3, X = 6
 * Output: [4, 5, 6]
 * Example 3:
 * <p>
 * Input: [2, 4, 5, 6, 9], K = 3, X = 10
 * Output: [5, 6, 9]
 */
public class KClosestNumbers {

    /**
     * Time complexity O(logN+ K)
     * Space complexity O(1)
     */
    public List<Integer> findClosestElements(int[] arr, int k, Integer X) {
        int minIndex = findMinDiff(arr, X);
        List<Integer> result = new ArrayList<>();
        result.add(arr[minIndex]);
        k--;

        int left = minIndex - 1;
        int right = minIndex + 1;
        while (k > 0) {
            if (left >= 0 && right < arr.length) {
                if (Math.abs(arr[left] - X) < Math.abs(arr[right] - X)) {
                    result.add(arr[left--]);
                } else {
                    result.add(arr[right++]);
                }
            } else if (left >= 0) {
                result.add(arr[left--]);
            } else {
                result.add(arr[right++]);
            }
            k--;
        }
        return result;
    }

    private int findMinDiff(int[] arr, int target) {
        if (target > arr[arr.length - 1]) {
            return arr.length - 1;
        }
        if (target < arr[0]) {
            return 0;
        }

        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        if ((arr[lo] - target) < (target - arr[hi])) {
            return lo;
        }
        return hi;
    }

    public List<Integer> findClosestElementsEdu(int[] arr, int K, Integer X) {
        int index = findMinDiff(arr, X);
        int low = index - K, high = index + K;
        low = Math.max(low, 0); // 'low' should not be less than zero
        high = Math.min(high, arr.length - 1); // 'high' should not be greater the size of the array

        PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
        // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
        for (int i = low; i <= high; i++)
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));

        // we need the top 'K' elements having smallest difference from 'X'
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);
        return result;
    }

    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
