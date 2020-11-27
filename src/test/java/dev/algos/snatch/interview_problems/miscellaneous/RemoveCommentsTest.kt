package dev.algos.snatch.interview_problems.miscellaneous

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RemoveCommentsTest {

    @Test
    fun test() {
        val instance = RemoveComments()
        assertEquals("", instance.removeComments(arrayOf("/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}")).toString())
    }
}
