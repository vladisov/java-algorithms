package dev.algos.snatch.interview_problems.merge_intervals

import dev.algos.snatch.interview_problems.helpers.Interval
import java.util.PriorityQueue
import kotlin.math.max

class EmployeeFreeTime {

    /**
     * Time O(NlogK)
     * Space O(K) without output
     */
    fun employeeFreeTime(schedule: List<List<Interval>>): ArrayList<Interval> {
        val result = ArrayList<Interval>()
        val queue = PriorityQueue<Info>(compareBy({ schedule[it.arrayIndex][it.elementIndex].start },
                { schedule[it.arrayIndex][it.elementIndex].end }))
        for (i in schedule.indices) {
            queue.add(Info(0, i))
        }
        var end = -1
        while (!queue.isEmpty()) {
            val info = queue.poll()
            val interval = schedule[info.arrayIndex][info.elementIndex]
            end = if (end < interval.start) {
                if (end != -1) result.add(Interval(end, interval.start))
                interval.end
            } else {
                max(end, interval.end)
            }
            if (info.elementIndex + 1 < schedule[info.arrayIndex].size) {
                queue.add(Info(info.elementIndex + 1, info.arrayIndex))
            }
        }
        return result
    }

    class Info(val elementIndex: Int, val arrayIndex: Int)
}

