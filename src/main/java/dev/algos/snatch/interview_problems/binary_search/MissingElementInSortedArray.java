package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.*
 */
public class MissingElementInSortedArray {

    /**
     * Time O(logn)
     * Space O(1)
     */
    public int missingElement(int[] nums, int k) {
        int lo = 0, hi = nums.length, min = nums[lo], missing = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int diff = nums[mid] - (min + mid); //3
            int add = k - diff;
            if (diff < k) {
                missing = nums[mid] + add;
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return missing;
    }
}
