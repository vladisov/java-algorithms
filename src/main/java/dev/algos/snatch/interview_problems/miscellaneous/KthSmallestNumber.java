package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it.
 * <p>
 * Please note that it is the Kth smallest number in the sorted order, not the Kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
 * Example 2:
 * <p>
 * Input: [1, 5, 12, 2, 11, 5], K = 4
 * Output: 5
 * Explanation: The 4th smallest number is '5', as the first three small numbers are [1, 2, 5].
 * Example 3:
 * <p>
 * Input: [5, 12, 11, -1, 12], K = 3
 * Output: 11
 * Explanation: The 3rd smallest number is '11', as the first two small numbers are [5, -1].
 */
public class KthSmallestNumber {

    /**
     * Time O(NlogK)
     * Space O(K)
     */
    public int findKthSmallestNumberMaxHeap(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return -1;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }

    /**
     * QuickSort
     * Time O(NlogN) O(N^2) worst
     * Space O(N)
     */
    public int findKthSmallestNumberQuickSort(int[] nums, int k) {
        return findKthSmallestNumberQuickSort(nums, k, 0, nums.length - 1);
    }

    public int findKthSmallestNumberQuickSort(int[] nums, int k, int lo, int hi) {
        int pivot = partitionMedianOfMedians(nums, lo, hi);
        if (pivot == k - 1) {
            return nums[pivot];
        }
        if (pivot < k - 1) {
            return findKthSmallestNumberQuickSort(nums, k, pivot + 1, hi);
        }
        return findKthSmallestNumberQuickSort(nums, k, lo, pivot);
    }

    /*
    The above algorithm has the same worst and average case time complexities as mentioned for the previous algorithm.
    But choosing the pivot randomly has the effect of rendering the worst-case very unlikely, particularly for large arrays.
    Therefore, the expected time complexity of the above algorithm will be O(N), but the absolute worst case is still O(N^2)
​​    Practically, this algorithm is a lot faster than the non-randomized version.
     */
    private int partition(int[] arr, int lo, int hi) {
//        int pivot = arr[lo]; // classic
        Random randomNum = new Random();
        int pivotIndex = lo + randomNum.nextInt(hi - lo);
        swap(arr, pivotIndex, lo);
        int pivot = arr[lo];

        int i = lo;
        int j = hi;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        return j;
    }

    /**
     * Time O(N) QuickSelect with median of medians partitioning
     */
    private int partitionMedianOfMedians(int[] nums, int low, int high) {
        if (low == high)
            return low;

        int median = medianOfMedians(nums, low, high);
        // find the median in the array and swap it with 'nums[high]' which will become our pivot
        for (int i = low; i < high; i++) {
            if (nums[i] == median) {
                swap(nums, i, high);
                break;
            }
        }

        int pivot = nums[high];
        for (int i = low; i < high; i++) {
            // all elements less than 'pivot' will be before the index 'low'
            if (nums[i] < pivot)
                swap(nums, low++, i);
        }
        // put the pivot in its correct place, remember nums[high] is our pivot
        swap(nums, low, high);
        return low;
    }

    /*
    If we have 5 or less than 5 elements in the input array, we simply take its first element as the pivot.
    If not then we divide the input array into subarrays of five elements (for simplicity we can ignore any subarray having less than five elements).

    Sort each subarray to determine its median. Sorting a small and fixed numbered array takes constant time.
    At the end of this step, we have an array containing medians of all the subarray.

    Recursively call the partitioning algorithm on the array containing medians until we get our pivot.

    Every time the partition procedure needs to find a pivot, it will follow the above three steps.
     */
    private int medianOfMedians(int[] nums, int low, int high) {
        int n = high - low + 1;
        // if we have less than 5 elements, ignore the partitioning algorithm
        if (n < 5)
            return nums[low];

        // for simplicity, lets ignore any partition with less than 5 elements
        int numOfPartitions = n / 5; // represents total number of 5 elements partitions
        int[] medians = new int[numOfPartitions];
        for (int i = 0; i < numOfPartitions; i++) {
            int partitionStart = low + i * 5; // starting index of the current partition
            Arrays.sort(nums, partitionStart, partitionStart + 5); // sort the 5 elements array
            medians[i] = nums[partitionStart + 2]; // get the middle element (or the median)
        }

        return partitionMedianOfMedians(medians, 0, numOfPartitions - 1);
    }
}
