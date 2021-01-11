package dev.algos.snatch.interview_problems.dp

import kotlin.math.min

fun minFallingPathSum(arr: Array<IntArray>): Int {
    val n = arr.size
    val m = arr[0].size
    if (n == 1) return arr[0][0]
    var ans = Int.MAX_VALUE
    var prevFmin = intArrayOf(Int.MAX_VALUE, -1) // value : column
    var prevSmin = intArrayOf(Int.MAX_VALUE, -1)
    for (i in 0 until n) {
        var fmin = intArrayOf(Int.MAX_VALUE, -1)
        var smin = intArrayOf(Int.MAX_VALUE, -1)
        for (j in 0 until m) {
            if (i != 0) {
                arr[i][j] += if (prevFmin[1] == j) prevSmin[0] else prevFmin[0]
            }
            if (arr[i][j] <= smin[0]) {
                smin = intArrayOf(arr[i][j], j)
            }
            if (arr[i][j] <= fmin[0]) {
                smin = fmin
                fmin = intArrayOf(arr[i][j], j)
            }
            if (i == n - 1) ans = min(ans, arr[i][j])
        }
        prevFmin = fmin
        prevSmin = smin
    }
    return ans
}
