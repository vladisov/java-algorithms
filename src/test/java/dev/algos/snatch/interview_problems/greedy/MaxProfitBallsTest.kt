package dev.algos.snatch.interview_problems.greedy

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MaxProfitBallsTest {
    @Test
    fun test() {
        val instance = MaxProfitBalls()
        assertEquals(131, instance.maxProfit(intArrayOf(2, 4, 6, 6, 9, 10), 23))
        assertEquals(373219333, instance.maxProfit(intArrayOf(497978859, 167261111, 483575207, 591815159), 836556809))
    }
}
