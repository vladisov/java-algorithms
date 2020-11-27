package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SortedArrayThroughInstructionsTest {

    @Test
    fun test() {
        val instance = SortedArrayThroughInstructions()
        assertEquals(3, instance.createSortedArray(intArrayOf(1, 2, 3, 6, 5, 4)))
        assertEquals(3, instance.createSortedArrayBIT(intArrayOf(1, 2, 3, 6, 5, 4)))
        assertEquals(4, instance.createSortedArray(intArrayOf(1, 3, 3, 3, 2, 4, 2, 1, 2)))
        assertEquals(4, instance.createSortedArrayBIT(intArrayOf(1, 3, 3, 3, 2, 4, 2, 1, 2)))
    }
}
