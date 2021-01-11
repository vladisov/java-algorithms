package dev.algos.snatch.interview_problems.greedy

import java.util.TreeSet
import kotlin.math.min

/**
 * Time O(NlogN) ?
 * Space O(N)
 */
fun minimumDeviation(nums: IntArray): Int {
    val tree = TreeSet<Int>()
    for (num in nums) {
        if (num % 2 == 0) {
            tree.add(num)
        } else {
            tree.add(num * 2)
        }
    }
    var diff = tree.last() - tree.first()
    while (tree.last() % 2 == 0) {
        val num = tree.last() / 2
        tree.remove(tree.last())
        tree.add(num)
        val newDiff = tree.last() - tree.first()
        diff = min(diff, newDiff)
    }
    return diff
}
