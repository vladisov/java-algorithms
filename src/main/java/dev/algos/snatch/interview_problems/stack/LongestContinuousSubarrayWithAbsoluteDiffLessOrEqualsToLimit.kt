package dev.algos.snatch.interview_problems.stack

import java.util.LinkedList
import kotlin.math.max

/**
Input: nums = [8,2,4,7], limit = 4
Output: 2
Explanation: All subarrays are:
[8] with maximum absolute diff |8-8| = 0 <= 4.
[8,2] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4] with maximum absolute diff |8-2| = 6 > 4.
[8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
[2] with maximum absolute diff |2-2| = 0 <= 4.
[2,4] with maximum absolute diff |2-4| = 2 <= 4.
[2,4,7] with maximum absolute diff |2-7| = 5 > 4.
[4] with maximum absolute diff |4-4| = 0 <= 4.
[4,7] with maximum absolute diff |4-7| = 3 <= 4.
[7] with maximum absolute diff |7-7| = 0 <= 4.
Therefore, the size of the longest subarray is 2.
 */
class LongestContinuousSubarrayWithAbsoluteDiffLessOrEqualsToLimit {

    /*
    8 2 4 7
    8,  2,  2 4, 2 4 7
    8, 8 2,  4,    7
     */
    /**
     * Time O(N)
     * Space O(N)
     */
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        // decreasing deque,  head is curr maximum for subarray
        val maxDeque = LinkedList<Int>()
        // head is curr minimum
        val minDeque = LinkedList<Int>()
        var start = 0;
        var ans = 0
        for (end in nums.indices) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[end]) {
                maxDeque.pollLast()
            }
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[end]) {
                minDeque.pollLast()
            }
            minDeque.add(end)
            maxDeque.add(end)
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (start == maxDeque.peekFirst()) maxDeque.pollFirst()
                if (start == minDeque.peekFirst()) minDeque.pollFirst()
                start++
            }
            ans = max(ans, end - start + 1)
        }
        return ans
    }
}
