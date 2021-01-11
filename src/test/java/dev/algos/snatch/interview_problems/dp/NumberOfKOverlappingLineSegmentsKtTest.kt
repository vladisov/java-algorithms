package dev.algos.snatch.interview_problems.dp

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class NumberOfKOverlappingLineSegmentsKtTest {

    @Test
    fun test() {
        assertEquals(5, numberOfSets(4, 2))
        assertEquals(931045476, numberOfSets(1000, 988))
    }

    @Test
    fun testNKTopDown() {
        assertEquals(5, numberOfSets2(4, 2))
        assertEquals(931045476, numberOfSets2(1000, 988))
    }

    @Test
    fun testBU() {
        assertEquals(5, numberOfSetsBU(4, 2))
        assertEquals(931045476, numberOfSetsBU(1000, 988))
    }

    @Test
    fun testBU2() {
        assertEquals(5, numberOfSets2BU(4, 2))
        assertEquals(931045476, numberOfSets2BU(1000, 988))
    }
}
