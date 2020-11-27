package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CloseStringsTest {

    @Test
    fun test() {
        val inst = CloseStrings()
        assertTrue(inst.closeStrings("cabbba", "abbccc"))
        assertFalse(inst.closeStrings("uuukuuuukkuusuususuuuukuskuusuuusuusuuuuuuk", "kssskkskkskssskksskskksssssksskksskskksksuu"))
    }
}
