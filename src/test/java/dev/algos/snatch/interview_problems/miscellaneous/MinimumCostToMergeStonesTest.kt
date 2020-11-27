package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumCostToMergeStonesTest {

    @Test
    fun test() {
        val merger = MinimumCostToMergeStones()
        assertEquals(20, merger.mergeStones(intArrayOf(3, 2, 4, 1), 2))
        assertEquals(40, merger.mergeStones(intArrayOf(6, 4, 4, 6), 2))
    }
}

