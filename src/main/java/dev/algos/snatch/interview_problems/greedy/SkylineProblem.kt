package dev.algos.snatch.interview_problems.greedy

import java.util.TreeMap

/**
 * https://leetcode.com/explore/featured/card/november-leetcoding-challenge/568/week-5-november-29th-november-30th/3549/
 */
class SkylineProblem {
    /**
     * Time O(NlogN)
     * Space O(N)
     */
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val points = mutableListOf<Point>()
        for (building in buildings) {
            val left = Point(building[0], building[2], true)
            val right = Point(building[2], building[1], false)
            points.add(left)
            points.add(right)
        }
        points.sort()
        val result = mutableListOf<List<Int>>()
        val queue = TreeMap<Int, Int>()
        queue[0] = 1 // if we remove end we take zero
        var prevMax = queue.lastKey()
        for (point in points) {
            if (point.start) {
                queue[point.y] = queue.getOrDefault(point.y, 0) + 1
            } else {
                queue[point.y] = queue.getOrDefault(point.y, 1) - 1
                if (queue[point.y]!! == 0) {
                    queue.remove(point.y) // we have to remove to get lastkey == 0
                }
            }
            val currMax = queue.lastKey()
            if (currMax != prevMax) {
                result.add(listOf(point.x, currMax))
                prevMax = currMax
            }
        }
        return result
    }

    class Point(val x: Int, val y: Int, val start: Boolean) : Comparable<Point> {
        override fun compareTo(other: Point): Int {
            if (this.x != other.x) {
                return this.x - other.x
            }
            if (this.start && other.start) {
                return other.y - this.y
            } else if (this.start && !other.start) {
                return -1
            } else if (!this.start && other.start) {
                return 1
            }
            return this.y - other.y
        }
    }
}
