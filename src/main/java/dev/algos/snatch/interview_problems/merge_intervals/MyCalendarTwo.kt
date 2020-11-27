package dev.algos.snatch.interview_problems.merge_intervals

import kotlin.math.max
import kotlin.math.min

class MyCalendarTwo {

    private val calendar = mutableListOf<IntArray>()
    private val overlaps = mutableListOf<IntArray>()

    fun book(start: Int, end: Int): Boolean {
        for ((overlapStart, overlapEnd) in overlaps) {
            if (end > overlapStart && start < overlapEnd) {
                return false
            }
        }
        for ((calendarStart, calendarEnd) in calendar) {
            if (end > calendarStart && start < calendarEnd) {
                overlaps.add(intArrayOf(max(start, calendarStart), min(end, calendarEnd)))
            }
        }
        calendar.add(intArrayOf(start, end))
        return true
    }

}
