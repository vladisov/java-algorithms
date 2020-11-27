package dev.algos.snatch.interview_problems.dp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DivideChocolateTest {

    @Test
    fun maximizeSweetness() {
        val instance = DivideChocolate()
        assertEquals(5, instance.maximizeSweetness(intArrayOf(1, 2, 2, 1, 2, 2, 1, 2, 2), 2))
        assertEquals(6, instance.maximizeSweetness(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
        assertEquals(1, instance.maximizeSweetness(intArrayOf(5, 6, 7, 8, 9, 1, 2, 3, 4), 8))
        assertEquals(4, instance.maximizeSweetness(intArrayOf(1, 2, 3, 4), 1))
    }
}
