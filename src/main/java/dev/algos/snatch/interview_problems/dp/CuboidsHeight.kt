package dev.algos.snatch.interview_problems.dp

import kotlin.math.max

/**
 * TIme O(N^2)
 * Space O(N^2)
 */
fun maxHeight(cuboids: Array<IntArray>): Int {
    val n = cuboids.size
    for (cub in cuboids) cub.sortDescending()
    cuboids.sortByDescending { it[0] * it[1] * it[2] }
    val dp = IntArray(n) { cuboids[it][2] }
    var max = 0
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (fits(cuboids[j], cuboids[i])) {
                dp[i] = max(cuboids[i][2] + dp[j], dp[i])
            }
        }
        max = max(max, dp[i])
    }
    return max
}

fun fits(a: IntArray, b: IntArray): Boolean {
    return a[2] <= b[2] && ((a[0] <= b[0] && a[1] <= b[1]) || (a[1] <= b[0] && a[0] <= b[1]))
}

