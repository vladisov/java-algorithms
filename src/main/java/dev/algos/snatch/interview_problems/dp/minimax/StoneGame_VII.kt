package dev.algos.snatch.interview_problems.dp.minimax

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun stoneGameVII(stones: IntArray): Int {
    val dp = Array(stones.size) { Array(stones.size) { Array<Int?>(2) { null } } }
    val prefix = buildPrefix(stones)
    return abs(helper(0, stones.size - 1, 1, stones, prefix, dp))
}

fun helper(i: Int, j: Int, turn: Int, stones: IntArray, prefix: IntArray, dp: Array<Array<Array<Int?>>>): Int {
    if (i > j) return 0
    if (dp[i][j][turn] != null) return dp[i][j][turn]!!
    val next = abs(turn - 1)
    val sumRight = prefix[j + 1] - prefix[i + 1]
    val sumLeft = prefix[j] - prefix[i]
    var ans = 0
    ans = if (turn == 1) {
        val left = sumRight + helper(i + 1, j, next, stones, prefix, dp)
        val right = sumLeft + helper(i, j - 1, next, stones, prefix, dp)
        max(ans, max(left, right))
    } else {
        val left = -sumRight + helper(i + 1, j, next, stones, prefix, dp)
        val right = -sumLeft + helper(i, j - 1, next, stones, prefix, dp)
        min(ans, min(left, right))
    }
    dp[i][j][turn] = ans
    return ans
}

fun buildPrefix(stones: IntArray): IntArray {
    val prefix = IntArray(stones.size + 1)
    for (i in stones.indices) prefix[i + 1] = prefix[i] + stones[i]
    return prefix
}

fun main() {
    println(stoneGameVII(intArrayOf(5, 3, 1, 4, 2)))
    println(stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)))
}
