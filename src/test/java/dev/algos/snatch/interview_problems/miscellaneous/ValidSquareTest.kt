package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ValidSquareTest {

    @Test
    fun test() {
        val square = ValidSquare()
        assertFalse(square.validSquare(intArrayOf(1, 1), intArrayOf(5, 3), intArrayOf(3, 5), intArrayOf(7, 7)))
        assertTrue(square.validSquare(intArrayOf(0, 0), intArrayOf(1, 1), intArrayOf(1, 0), intArrayOf(0, 1)))
        assertFalse(square.validSquare(intArrayOf(0, 0), intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1)))
        assertTrue(square.validSquare(intArrayOf(1134, -2539), intArrayOf(492, -1255), intArrayOf(-792, -1897), intArrayOf(-150, -3181)))
    }
}
