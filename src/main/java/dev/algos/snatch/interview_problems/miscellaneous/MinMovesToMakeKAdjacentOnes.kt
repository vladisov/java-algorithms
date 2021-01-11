package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.min

/**
 * Time O(N)
 * Space O(N)
 */
fun minMoves(nums: IntArray, k: Int): Int {
    val ones = mutableListOf<Int>()
    for (i in nums.indices) if (nums[i] == 1) ones.add(i)
    val prefix = buildPrefix(ones)
    val radius = (k - 1) / 2
    var min = Int.MAX_VALUE
    return if (k % 2 != 0) {
        for (i in radius until ones.size - radius) {
            val left = prefix[i] - prefix[i - radius]
            val right = prefix[i + radius + 1] - prefix[i + 1]
            min = min(right - left, min) //right - left - equation..
        }
        min - radius * (radius + 1)
    } else {
        for (i in radius until ones.size - radius - 1) {
            val left = prefix[i] - prefix[i - radius]
            val right = prefix[i + radius + 2] - prefix[i + 1]
            min = min(right - left - ones[i], min) // - prefix[i] if even
        }
        min - radius * (radius + 1) - (radius + 1)
    }
}

fun buildPrefix(stones: MutableList<Int>): IntArray {
    val prefix = IntArray(stones.size + 1)
    for (i in stones.indices) prefix[i + 1] = prefix[i] + stones[i]
    return prefix
}

fun main() {
    println(minMoves(intArrayOf(1, 0, 0, 1, 0, 1), 2))
}

/*
k = 3
0 1 2
k = 4
0 1 2 3

1 2 3 4 5
0 1 3 6 10 15

0 0 1 3 6

(1 + 2 + n) * 2 = (n(n + 1)/2 ) * 2 = n * (n + 1)
 */
