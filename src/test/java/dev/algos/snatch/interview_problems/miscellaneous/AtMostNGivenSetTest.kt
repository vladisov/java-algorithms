package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class AtMostNGivenSetTest {

    @Test
    fun test() {
        val inst = AtMostNGivenSet()
        assertEquals(20, inst.atMostNGivenDigitSet(arrayOf("1", "3", "5", "7"), 100))
        assertEquals(18, inst.atMostNGivenDigitSet(arrayOf("3", "4", "5", "6"), 64))
        assertEquals(3, inst.atMostNGivenDigitSet(arrayOf("1", "4"), 12))
        assertEquals(1, inst.atMostNGivenDigitSet(arrayOf("7"), 8))
    }
}
