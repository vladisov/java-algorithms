package dev.algos.snatch.interview_problems.dp

import java.util.Arrays

fun numberOfSets(n: Int, k: Int): Int {
    val dp = Array(n) { IntArray(k + 1) }
    for (i in 0 until n) Arrays.fill(dp[i], -1)
    return helper(n, k, 0, dp)
}

fun helper(n: Int, k: Int, start: Int, dp: Array<IntArray>): Int {
    if (k == 0) return 1
    if (start == n) return 0
    if (dp[start][k] != -1) {
        return dp[start][k]
    }
    var ans = 0
    for (i in start + 1 until n) {
        ans = (ans + helper(n, k - 1, i, dp)) % 1_000_000_007
    }
    ans = (ans + helper(n, k, start + 1, dp)) % 1_000_000_007
    dp[start][k] = ans
    return ans
}

//very slow
fun numberOfSetsBU(n: Int, k: Int): Int {
    val dp = Array(n + 1) { Array(k + 1) { MInt(0) } }
    dp[n][0] = MInt(1)
    for (i in n - 1 downTo 0) {
        dp[i][0] = MInt(1)
        for (j in 1..k) {
            for (l in i + 1 until n) {
                dp[i][j] += dp[l][j - 1]
            }
            dp[i][j] += dp[i + 1][j]
        }
    }
    return dp[0][k].int
}

fun numberOfSets2(n: Int, k: Int): Int {
    return dp(n, k, 0, 0, Array(n) { Array(k + 1) { Array(2) { null } } }).int
}

fun dp(n: Int, k: Int, i: Int, start: Int, memo: Array<Array<Array<MInt?>>>): MInt {
    if (k == 0) return MInt(1)
    if (i == n) return MInt(0)
    memo[i][k][start] = memo[i][k][start]
            ?: dp(n, k, i + 1, start, memo) + dp(n, k - start, i + (start xor 1), (start xor 1), memo)
    return memo[i][k][start]!!
}

fun numberOfSets2BU(n: Int, k: Int): Int {
    val dp = Array(n + 1) { Array(k + 1) { Array(2) { MInt(0) } } }
    dp[n][0][0] = MInt(1)
    for (i in n - 1 downTo 0) {
        dp[i][0][0] = MInt(1)
        dp[i][0][1] = MInt(1)
        for (j in 1..k) {
            dp[i][j][0] += dp[i + 1][j][0]
            dp[i][j][0] += dp[i + 1][j][1]
            dp[i][j][1] += dp[i + 1][j][1]
            dp[i][j][1] += dp[i][j - 1][0]
        }
    }
    return dp[0][k][0].int
}

class MInt(val int: Int) {
    operator fun plus(other: MInt) = MInt((int + other.int) % 1_000_000_007)
}
