package dev.algos.snatch.interview_problems.stack

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestContinuousSubarrayWithAbsoluteDiffLessOrEqualsToLimitTest {

    @Test
    fun test() {
        val instance = LongestContinuousSubarrayWithAbsoluteDiffLessOrEqualsToLimit()
        assertEquals(2, instance.longestSubarray(intArrayOf(8, 2, 4, 7), 4))
    }
}
