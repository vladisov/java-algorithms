package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MirrorReflectionTest {
    @Test
    fun test() {
        val instance = MirrorReflection()
        assertEquals(0, instance.mirrorReflection(9, 4))
    }
}
