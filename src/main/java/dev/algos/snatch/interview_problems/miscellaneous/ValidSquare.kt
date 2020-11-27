package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.abs

class ValidSquare {

    /**
     * Time O(1)
     * Space O(1)
     */
    fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
        val tmp = mutableListOf(p1, p2, p3, p4)
        tmp.sortWith(compareBy({ it[1] }, { it[0] }))
        val ld = tmp[0]
        val lt = tmp[1]
        val rd = tmp[2]
        val rt = tmp[3]
        val l1 = d(ld, rd)
        val l2 = d(rd, rt)
        val l3 = d(lt, rt)
        val l4 = d(ld, lt)
        val l5 = d(ld, rt)
        val l6 = d(rd, lt)
        return l1 > 0 && l1 == l2 && l2 == l3 && l3 == l4 && l5 == l6
    }

    private fun d(left: IntArray, mid: IntArray) = abs(left[0] - mid[0]).toDouble() + abs(left[1] - mid[1])
}
