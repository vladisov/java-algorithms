package dev.algos.snatch.interview_problems.merge_intervals

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class MyCalendarThreeTest {

    @Test
    fun book() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(10, 20)) // returns 1
        assertEquals(1, calendar.book(50, 60)) // returns 1
        assertEquals(2, calendar.book(10, 40)) // returns 2
        assertEquals(3, calendar.book(5, 15)) // returns 3
        assertEquals(3, calendar.book(5, 10)) // returns 3
        assertEquals(3, calendar.book(25, 55)) // returns 3
    }
}
