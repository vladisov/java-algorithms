package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.min

class MinimumCostToMergeStones {

    /*
    We keep merging K piles of stones until there is only one pile.
    For the last step, stones[i .. j] are divided into K piles, and we merge them into one pile,
    which costs sum(nums[i .. j]) + cost to make stones[i .. j] form K piles.
    The problem get the minimum cost to make stones[i .. j] form 1 pile equals to
	the minimum cost to make stones[i .. j] form K piles + sum(nums[i .. j])

    The subproblem the minimum cost to make stones[i .. j] form K piles equals to
	the minimum cost to make stones[i .. k] form K - 1 piles
	+ the minimum cost to make stones[k + 1 .. j] form 1 pile
	+ sum(nums[i .. j])

    Input: stones = [3,2,4,1], K = 2
    Output: 20
    Explanation:
    We start with [3, 2, 4, 1].

    We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
    We merge [4, 1] for a cost of 5, and we are left with [5, 5].
    We merge [5, 5] for a cost of 10, and we are left with [10].
    The total cost was 20, and this is the minimum possible.

    3 2 4 1

     */


    fun mergeStones(stones: IntArray, k: Int): Int {
        val prefix = stones.scan(0, Int::plus)
        val dp = Array(stones.size + 1) { Array(stones.size + 1) { IntArray(k + 1) } }
        val min = helper(1, stones.size, 1, k, stones, prefix, dp)
        return if (min == Int.MAX_VALUE) -1 else min
    }

    // Minimum cost merging piles from i to j into targetPiles pile.
    private fun helper(i: Int, j: Int, piles: Int, k: Int, stones: IntArray, prefix: List<Int>, dp: Array<Array<IntArray>>): Int {
        if (j - i + 1 < piles) return Int.MAX_VALUE
        if (i == j) return if (piles == 1) 0 else Int.MAX_VALUE
        if (dp[i][j][piles] == 0) {
            if (piles == 1) {
                val sub = helper(i, j, k, k, stones, prefix, dp)
                dp[i][j][piles] = if (sub != Int.MAX_VALUE) prefix[j] - prefix[i - 1] + sub else sub
            } else {
                var min = Int.MAX_VALUE
                for (m in i until j) {
                    val left = helper(i, m, piles - 1, k, stones, prefix, dp)
                    if (left == Int.MAX_VALUE) continue
                    val right = helper(m + 1, j, 1, k, stones, prefix, dp)
                    if (right == Int.MAX_VALUE) continue
                    min = min(left + right, min)
                }
                dp[i][j][piles] = min
            }
        }
        return dp[i][j][piles]
    }
}
