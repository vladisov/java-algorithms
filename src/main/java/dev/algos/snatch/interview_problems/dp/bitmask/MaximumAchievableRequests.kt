package dev.algos.snatch.interview_problems.dp.bitmask

import kotlin.math.max

/**
 * Time O(2^N)
 * Space O(2^N)
 */
fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
    return helper(0, requests, 0, IntArray(n), mutableMapOf())
}

fun helper(i: Int, requests: Array<IntArray>, visited: Int, buildings: IntArray, dp: MutableMap<Int, Int>): Int {
    if (i == requests.size && buildings.none { it != 0 }) return 0
    if (i == requests.size) return -1
    if (!dp.containsKey(visited)) {
        buildings[requests[i][0]]--
        buildings[requests[i][1]]++
        val take = helper(i + 1, requests, visited or (1 shl i), buildings, dp)
        buildings[requests[i][0]]++
        buildings[requests[i][1]]--
        val skip = helper(i + 1, requests, visited, buildings, dp)
        if ((take != -1 && skip != -1) || (take != -1 || skip != -1)) {
            dp[visited] = max(1 + take, skip)
        } else {
            dp[visited] = -1
        }
    }
    return dp[visited]!!
}
