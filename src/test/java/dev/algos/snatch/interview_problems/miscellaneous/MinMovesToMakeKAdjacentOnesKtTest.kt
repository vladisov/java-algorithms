package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.test.assertEquals

internal class MinMovesToMakeKAdjacentOnesKtTest {

    fun test() {
        assertEquals(5, minMoves(intArrayOf(1, 0, 0, 0, 0, 0, 1, 1), 3))
        assertEquals(5, minMoves(intArrayOf(1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1), 7))
        assertEquals(5, minMoves(intArrayOf(1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0), 15))
        assertEquals(5, minMoves(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0), 12))
        assertEquals(5, minMoves(intArrayOf(1, 1, 1, 1, 1), 5))
        assertEquals(5, minMoves(intArrayOf(1, 0, 0, 1, 0, 1), 2))
    }
}
