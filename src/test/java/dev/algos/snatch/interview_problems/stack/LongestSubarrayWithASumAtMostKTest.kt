package dev.algos.snatch.interview_problems.stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestSubarrayWithASumAtMostKTest {

    @Test
    fun test() {
        val instance = LongestSubarrayWithASumAtMostK()
        assertEquals(3, instance.longestSumArray(intArrayOf(5, -10, 7, -20, 57), -22))
    }
}
