package dev.algos.snatch.interview_problems.prefix_sum

import kotlin.math.max

class MinimumNumberOfOperationsToReduceXToZero {

    /*
    10 1,1,4,2,3   15

    10 11 12 16 18 21, total - 21, subarray with sum = 6

    total = 25
    total - ? = target
    currSum - ? = y
    total - (currSum - ?) = target
    total - currSum + ? = target
    ? = target + currSum - total

    total - k = x
     */
    /**
     * Time O(N)
     * Space
     */
    fun minOperations(nums: IntArray, x: Int): Int {
        val map = mutableMapOf<Int, Int>()
        map[0] = -1
        var sum = 0
        var max = -1
        val k = nums.sum() - x
        for (i in nums.indices) {
            sum += nums[i]
            if (map.containsKey(sum - k)) {
                max = max(max, i - map[sum - k]!!)
            }
            map.putIfAbsent(sum, i)
        }
        if (max == -1) return max
        return nums.size - max
    }
}
