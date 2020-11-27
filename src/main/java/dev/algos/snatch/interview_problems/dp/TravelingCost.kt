package dev.algos.snatch.interview_problems.dp

import kotlin.math.abs
import kotlin.math.max

class TravelingCost {

    /**
     * Time O(N*2)
     * Space O(N*2)
     */
    fun getMaxProfit(revA: IntArray, revB: IntArray, cost: Int): Int {
        val cities = arrayOf(revA, revB)
        val days = revA.size
        return max(
                helper(0, 0, cost, cities, Array(2) { IntArray(days) }),
                helper(0, 1, cost, cities, Array(2) { IntArray(days) })
        )
    }

    fun helper(day: Int, city: Int, cost: Int, cities: Array<IntArray>, dp: Array<IntArray>): Int {
        if (day == cities[0].size) return 0
        if (dp[city][day] == 0) {
            val stay = cities[city][day] + helper(day + 1, city, cost, cities, dp)
            val move = cities[city][day] + helper(day + 1, abs(city - 1), cost, cities, dp) - cost
            dp[city][day] = max(stay, move)
        }
        return dp[city][day]
    }

    fun getMaxProfitBU(revA: IntArray, revB: IntArray, cost: Int): Int {
        val days = revA.size
        val dp = Array(days) { IntArray(2) }
        dp[0][0] = revA[0]
        dp[0][1] = revB[0]
        for (i in 1 until days) {
            dp[i][0] = revA[i] + max(dp[i - 1][0], dp[i - 1][1] - cost)
            dp[i][1] = revB[i] + max(dp[i - 1][1], dp[i - 1][0] - cost)
        }
        return max(dp[days - 1][0], dp[days - 1][1])
    }
}
