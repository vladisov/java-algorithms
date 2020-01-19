package dev.algos.snatch.interview_problems.gss.slidingWindow;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class LongestSubarrayWithOnesAfterReplacement {

    int findLength(int[] arr, int k) {
        int windowStart = 0;
        int maxOnes = 0;
        int result = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnes++;
            }
            if (windowEnd - windowStart + 1 - maxOnes > k) {
                if (arr[windowStart] == 1) {
                    maxOnes--;
                }
                windowStart++;
            }
            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }
}
