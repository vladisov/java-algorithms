package dev.algos.snatch.interview_problems.backtracking

import kotlin.math.min


fun tilingRectangle(n: Int, m: Int): Int {
    return getMin(n, m, 0, 0, IntArray(m), mutableMapOf())
}

fun getMin(n: Int, m: Int, x: Int, y: Int, skyline: IntArray, dp: MutableMap<String, Int>): Int {
    if (skyline[y] == n) return 0
    var i = x
    var j = y
    var min = 13 * 13
    val key = skyline.contentToString()
    if (dp.containsKey(key)) {
        return dp[key]!!
    }
    while (i < n && j < m) {
        var k = 0
        while (k + x <= i && k + y <= j && skyline[k + y] <= skyline[y]) k++
        val size = k + skyline[y]
        for (l in y until k + y) skyline[l] = size
        val (nextX, nextY) = getNext(skyline)
        min = min(min, 1 + getMin(n, m, nextX, nextY, skyline, dp))
        val oldSize = skyline[y] - k
        for (l in y until k + y) skyline[l] = oldSize
        i++; j++
    }
    dp[key] = min
    return min
}

fun getNext(skyline: IntArray): IntArray {
    var min = 13 * 13
    var minIndex = 0
    for (i in skyline.indices) {
        if (skyline[i] < min) {
            min = skyline[i]
            minIndex = i
        }
    }
    return intArrayOf(min, minIndex)
}


fun main() {
    println(tilingRectangle(2, 3))
    println(tilingRectangle(5, 8))
    println(tilingRectangle(11, 13))
}

/*
1 1 1 0 0 0
1 1 1 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0


0 0 0 0 0 0
3 3 3 0 0 0

 */


/*
1 1 1 0 0 0
1 1 1 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
 */

