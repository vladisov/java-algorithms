package dev.algos.snatch.interview_problems.backtracking

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class MaximizeGridHappinessTest {

    @Test
    @Disabled
    fun getMaxGridHappiness() {
        val instance = MaximizeGridHappiness()
        assertEquals(240, instance.getMaxGridHappiness(2, 3, 1, 2))
        assertEquals(360, instance.getMaxGridHappiness(4, 4, 2, 2))
    }
}
