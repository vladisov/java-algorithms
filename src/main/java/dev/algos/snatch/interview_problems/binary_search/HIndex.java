package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * <p>
 * Example:
 * <p>
 * Input: citations = [0,1,3,5,6]
 * Output: 3
 * Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
 * received 0, 1, 3, 5, 6 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining
 * two with no more than 3 citations each, her h-index is 3.
 */
public class HIndex {

    /**
     * Time O(logn)
     * Space O(1)
     */
    public int hIndex(int[] arr) {
        int lo = 0, hi = arr.length - 1, hIndex = 0, n = arr.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int val = arr[mid];
            int len = n - mid;
            hIndex = Math.max(Math.min(val, len), hIndex);
            if (val < len) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hIndex;
    }
}
