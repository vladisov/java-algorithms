package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinimumSwapsToMakeStringsEqualTest {

    @Test
    fun minimumSwap() {
        val inst = MinimumSwapsToMakeStringsEqual()
        assertEquals(4, inst.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"))
    }
}
