package dev.algos.snatch.interview_problems.dp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TravelingCostTest {

    @Test
    fun test() {
        val inst = TravelingCost()
        val topDown = inst.getMaxProfit(intArrayOf(3, 7, 2, 100), intArrayOf(1, 1, 1, 10), 2)
        val bottomUp = inst.getMaxProfitBU(intArrayOf(3, 7, 2, 100), intArrayOf(1, 1, 1, 10), 2)
        assertEquals(topDown, bottomUp)
    }
}
