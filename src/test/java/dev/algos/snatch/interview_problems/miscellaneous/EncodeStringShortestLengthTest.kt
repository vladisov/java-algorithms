package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class EncodeStringShortestLengthTest {

    @Test
    fun test() {
        val enc = EncodeStringShortestLength()
        assertEquals("2[abcdef]11[f]2[fedcba]", enc.encode("aaaaaaaaaaaaaaaaaaaabbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
        assertEquals("2[abcdef]11[f]2[fedcba]", enc.encode("abcdefabcdefffffffffffffedcbafedcba"))
        assertEquals("2[2[abbb]c]", enc.encode("abbbabbbcabbbabbbc"))
        assertEquals("2[aabc]d", enc.encode("aabcaabcd"))
        assertEquals("5[a]", enc.encode("aaaaa"))
        assertEquals("aaa", enc.encode("aaa"))
    }
}
