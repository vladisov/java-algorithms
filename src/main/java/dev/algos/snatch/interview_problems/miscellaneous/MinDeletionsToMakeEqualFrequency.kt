package dev.algos.snatch.interview_problems.miscellaneous

import java.util.Stack

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
class MinDeletionsToMakeEqualFrequency {

    /**
     * Time O(N)
     */
    fun minDeletions(s: String): Int {
        val map = IntArray(26)
        for (c in s) {
            map[c - 'a']++
        }
        val freq = mutableSetOf<Int>()
        var max = 0
        for (i in map) {
            freq.add(i)
            max = Integer.max(max, i)
        }
        val stack = Stack<Int>()
        for (i in 1 until max) {
            if (!freq.contains(i)) {
                stack.add(i)
            }
        }
        map.sort()
        var ans = 0
        for (i in 24 downTo 0) {
            if (map[i] == 0) continue
            while (!stack.isEmpty() && stack.peek() > map[i]) {
                stack.pop()
            }
            if (map[i] == map[i + 1]) {
                val available = if (!stack.isEmpty()) stack.pop() else 0
                ans += map[i] - available
            }
        }
        return ans
    }
}

