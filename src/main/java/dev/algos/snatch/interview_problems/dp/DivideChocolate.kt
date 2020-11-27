package dev.algos.snatch.interview_problems.dp

import kotlin.math.max
import kotlin.math.min

class DivideChocolate {

    /**
     * Time O(NK)
     * Space O(NK)
     * TLE!!!
     */
    fun maximizeSweetnessTLE(sweetness: IntArray, K: Int): Int {
        val prefix = sweetness.scan(0, Int::plus)
        return helper(0, sweetness, prefix, K, Array(sweetness.size) { IntArray(K + 1) })
    }

    private fun helper(start: Int, sweetness: IntArray, prefix: List<Int>, k: Int, dp: Array<IntArray>): Int {
        if (k == 0) return prefix[sweetness.size] - prefix[start]
        if (dp[start][k] == 0) {
            var max = 0
            for (i in start until sweetness.size - k) {
                val left = prefix[i + 1] - prefix[start]
                val right = helper(i + 1, sweetness, prefix, k - 1, dp)
                max = max(min(left, right), max)
            }
            dp[start][k] = max
        }
        return dp[start][k]
    }


    fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
        var lo = 1
        var hi = sweetness.sum()
        while (lo < hi) {
            val mid = (lo + hi + 1) / 2 //Quick tip: if you have left = mid, use left + right + 1.
            var splits = 0
            var curr = 0
            for (sweet in sweetness) {
                curr += sweet
                if (curr >= mid) {
                    curr = 0
                    splits++
                }
            }
            if (splits >= k + 1) {
                lo = mid
            } else {
                hi = mid - 1
            }
        }
        return lo
    }
}
/*
1,2|,2,1,2|,2,1,2|,2

0 1 3 5
0 1 2| 3 |4
 */
