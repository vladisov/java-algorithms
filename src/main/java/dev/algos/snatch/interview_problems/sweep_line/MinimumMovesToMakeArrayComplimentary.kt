package dev.algos.snatch.interview_problems.sweep_line

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/minimum-moves-to-make-array-complementary
 *
 * Time O(N)
 * Space O(N)
 */
fun minMoves(nums: IntArray, limit: Int): Int {
    val delta = IntArray(2 * limit + 2) // nums[i] <= limit
    for (i in 0 until (nums.size / 2)) {
        val a = nums[i]
        val b = nums[nums.size - 1 - i]
        delta[2] += 2
        delta[min(a, b) + 1]--
        delta[a + b]--
        delta[a + b + 1]++
        delta[max(a, b) + limit + 1]++
    }
    var max = 2 * nums.size // 2 per each
    var curr = 0
    for (i in 2 until delta.size) {
        curr += delta[i]
        max = min(max, curr)
    }
    return max
}

/*
4,4,7,4,7,7,7,10,10,10,4,10,4,4 limit = 10
8,8,17,8,17,17,17 -> two moves for 8 and 1 for 17
8,8,8,17,17,17,17

1. possible moves ->
0 moves when A + B = 0
1 move when T < A + B && min(A, B) + 1 <= T
1 move when T > A + B && T <= max(A,B) + limit
2 moves when T < A + B && min(A, B) >= T
2 moves when T > A + B && T > max(A,B) + limit

then apply sweep line
 */
