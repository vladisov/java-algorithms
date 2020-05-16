package dev.algos.snatch.interview_problems.binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 */
public class CountSmallerNumberAfterSelf {

    /**
     * Time O(NlogN)
     * Space O(logN)
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, count, 0, nums.length - 1);
        for (int value : count) {
            res.add(value);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, indexes, count, start, mid);
        mergeSort(nums, indexes, count, mid + 1, end);
        merge(nums, indexes, count, start, end);
    }

    private void merge(int[] nums, int[] indexes, int[] count, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        int[] left = new int[mid - lo + 1];
        int[] right = new int[hi - mid];
        for (int i = lo, j = 0; i <= mid; i++, j++) {
            left[j] = indexes[i];
        }
        for (int i = mid + 1, j = 0; i <= hi; i++, j++) {
            right[j] = indexes[i];
        }

        int k = lo, i = 0, j = 0, rightCount = 0;
        while (i < left.length && j < right.length) {
            if (nums[right[j]] < nums[left[i]]) {
                rightCount++;
                indexes[k++] = right[j++];
            } else {
                count[left[i]] += rightCount;
                indexes[k++] = left[i++];
            }
        }
        while (i < left.length) {
            count[left[i]] += rightCount;
            indexes[k++] = left[i++];
        }
        while (j < right.length) {
            indexes[k++] = right[j++];
        }
    }

    /**
     * BruteForce N^2
     */
    public List<Integer> countSmallerBF(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (list.isEmpty()) {
                result.add(0);
            } else {
                int n = floor(list, nums[i]);
                result.add(n);
            }
            addToList(list, nums[i]);
        }
        return result;
    }

    private int floor(List<Integer> list, int num) {
        if (list.size() == 0) {
            return 0;
        }
        int lo = 0, hi = list.size() - 1;
        int floor = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < num) {
                floor = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return floor + 1;
    }


    private void addToList(List<Integer> list, int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) > num) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (hi == -1 || list.get(hi) < num) {
            hi++;
        }
        list.add(hi, num);
    }
}
