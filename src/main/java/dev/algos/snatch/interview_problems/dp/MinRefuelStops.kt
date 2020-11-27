package dev.algos.snatch.interview_problems.dp

import java.util.HashMap
import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

class MinRefuelStops {
    /**
     * TLE
     * O(N*F)
     */
    fun minRefuelStopsTD(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val map = HashMap<String, Int>()
        return helper(0, target, startFuel, stations, map)
    }

    fun helper(next: Int, target: Int, fuel: Int, stations: Array<IntArray>, dp: MutableMap<String, Int>): Int {
        if (fuel >= target) return 0
        if (next == stations.size || fuel < stations[next][0]) return -1
        val fuelToGet = stations[next][1]
        val key = next.toString() + "_" + fuel
        if (!dp.containsKey(key)) {
            val take = helper(next + 1, target, fuel + fuelToGet, stations, dp)
            val skip = helper(next + 1, target, fuel, stations, dp)
            var ans = -1
            if (take != -1 && skip != -1) {
                ans = min(take + 1, skip)
            } else if (take != -1) {
                ans = take + 1
            } else if (skip != -1) {
                ans = skip
            }
            dp[key] = ans
        }
        return dp[key]!!
    }


    /*

    Let's determine dp[i], the farthest location we can get to using i refueling stops.
    This is motivated by the fact that we want the smallest i for which dp[i] >= target.

    Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
    [10,70,100,130]
     */
    /**
     * Time O(N^2)
     * Space O(N)
     */
    fun minRefuelStopsDP(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val n = stations.size
        val dp = LongArray(n + 1)
        dp[0] = startFuel.toLong()
        for (i in 0 until n)
            for (t in i downTo 0) {
                if (dp[t] >= stations[i][0]) {
                    dp[t + 1] = max(dp[t + 1], dp[t] + stations[i][1])
                }
            }
        for (i in 0..n) if (dp[i] >= target) return i
        return -1
    }

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        val queue = PriorityQueue<Int> { a, b -> b - a }
        var (maxReachable, stops, i, n) = listOf(startFuel, 0, 0, stations.size)
        while (maxReachable < target) {
            while (i < n && maxReachable >= stations[i][0]) queue.add(stations[i++][1])
            if (queue.isEmpty()) return -1
            maxReachable += queue.poll()
            stops++
        }
        return stops
    }
}
