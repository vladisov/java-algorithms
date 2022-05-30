package dev.algos.snatch.interview_problems.dp

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class CatAndMouse_IIKtTest {

    @Test
    fun test() {
        assertTrue { canMouseWin(arrayOf(".....MC", "F######"), 1, 1) }
        assertTrue { canMouseWin(arrayOf("####F", "#C...", "M...."), 1, 2) }
        assertTrue { canMouseWin(arrayOf(".M...", "..#..", "#..#.", "C#.#.", "...#F"), 3, 1) }
        assertFalse { canMouseWin(arrayOf("C...#", "...#F", "....#", "M...."), 2, 5) }
        assertTrue { canMouseWin(arrayOf("M.C...F"), 1, 4) }
        assertFalse { canMouseWin(arrayOf("M.C...F"), 1, 3) }
    }
}
