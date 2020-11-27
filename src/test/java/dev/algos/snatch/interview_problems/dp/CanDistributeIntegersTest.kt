package dev.algos.snatch.interview_problems.dp

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CanDistributeIntegersTest {

    @Test
    fun test() {
        val instance = CanDistributeIntegers()
        assertTrue(instance.canDistribute(intArrayOf(1, 1, 2, 2), intArrayOf(2, 2)))
        assertTrue(instance.canDistributeOptimized(intArrayOf(1, 1, 2, 2), intArrayOf(2, 2)))
        assertFalse(instance.canDistribute(intArrayOf(1, 1, 2, 3), intArrayOf(2, 2)))
        assertFalse(instance.canDistributeOptimized(intArrayOf(1, 1, 2, 3), intArrayOf(2, 2)))
    }
}
