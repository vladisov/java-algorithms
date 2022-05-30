package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.max
import kotlin.math.min

class ChangeMinChars {

    fun minCharacters(a: String, b: String): Int {
        return min(min(helper(a, b), helper(b, a)), helperLongest(a, b))
    }

    fun helper(a: String, b: String): Int {
        var res = a.length + b.length
        for (i in 0..24) {
            var count = 0
            for (c in a) {
                if (c - 'a' > i) count++
            }
            for (c in b) {
                if (c - 'a' <= i) count++
            }
            res = min(res, count)
        }
        return res
    }

    fun helperLongest(a: String, b: String): Int {
        return a.length - getLongest(a) + b.length - getLongest(b)
    }

    private fun getLongest(a: String): Int {
        var max = 1
        val map = IntArray(26)
        for (element in a) {
            map[element - 'a']++
        }
        for (i in 0..25) {
            max = max(max, map[i])
        }
        return max
    }

}

fun main() {
    ChangeMinChars().minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz")
}
