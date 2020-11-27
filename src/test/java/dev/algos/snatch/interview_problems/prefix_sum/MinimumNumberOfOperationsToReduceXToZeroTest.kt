package dev.algos.snatch.interview_problems.prefix_sum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumNumberOfOperationsToReduceXToZeroTest {

    @Test
    fun minOperations() {
        val instance = MinimumNumberOfOperationsToReduceXToZero()
        assertEquals(3, instance.minOperations(intArrayOf(10, 1, 1, 4, 2, 3), 15))
    }
}
