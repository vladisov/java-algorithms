package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.ceil
import kotlin.math.log2
import kotlin.math.min

class SortedArrayThroughInstructions {
    fun createSortedArray(instructions: IntArray): Int {
        val mod = 1_000_000_007
        val arr = IntArray(10001)
        val tree = SegmentTree(arr)
        var cost = 0
        for (num in instructions) {
            cost = (cost + min(tree.get(0, num - 1), tree.get(num + 1, 10000))) % mod
            tree.update(num, arr[num] + 1)
        }
        return cost
    }

    fun createSortedArrayBIT(instructions: IntArray): Int {
        val mod = 1_000_000_007
        val bit = IntArray(10001)
        var cost = 0
        for ((index, num) in instructions.withIndex()) {
            cost = (cost + min(getFromBIT(bit, num - 1), index - getFromBIT(bit, num))) % mod
            updateBIT(bit, num)
        }
        return cost
    }

    private fun getFromBIT(arr: IntArray, num: Int): Int {
        var x = num
        var res = 0
        while (x > 0) {
            res += arr[x]
            x -= x and -x
        }
        return res
    }

    fun updateBIT(arr: IntArray, num: Int) {
        var x = num
        while (x < arr.size) {
            arr[x]++
            x += x and -x
        }
    }

    class SegmentTree(val arr: IntArray) {
        val tree: IntArray

        init {
            val n = arr.size
            val height = ceil(log2(n.toDouble()))
            val size = 2 * (1 shl height.toInt()) - 1
            tree = IntArray(size)
            construct(arr, 0, n - 1, 0)
        }

        private fun construct(arr: IntArray, lo: Int, hi: Int, index: Int): Int {
            if (lo == hi) {
                tree[lo] = arr[lo]
                return arr[lo]
            }
            val mid = mid(lo, hi)
            tree[index] = construct(arr, lo, mid, 2 * index + 1) + construct(arr, mid + 1, hi, 2 * index + 2)
            return tree[index]
        }

        private fun mid(lo: Int, hi: Int) = lo + (hi - lo) / 2

        fun get(rangeStart: Int, rangeEnd: Int): Int {
            return query(rangeStart, rangeEnd, 0, arr.size - 1, 0)
        }

        private fun query(rangeStart: Int, rangeEnd: Int, lo: Int, hi: Int, index: Int): Int {
            if (rangeStart <= lo && rangeEnd >= hi) {
                return tree[index]
            }
            if (rangeEnd < lo || rangeStart > hi) return 0

            val mid = mid(lo, hi)
            return query(rangeStart, rangeEnd, lo, mid, 2 * index + 1) +
                    query(rangeStart, rangeEnd, mid + 1, hi, 2 * index + 2)
        }

        fun update(index: Int, value: Int) {
            val diff = value - arr[index]
            arr[index] = value
            updateHelper(0, arr.size - 1, diff, index, 0)
        }

        private fun updateHelper(lo: Int, hi: Int, diff: Int, arrIndex: Int, index: Int) {
            if (arrIndex < lo || arrIndex > hi) return
            tree[index] += diff
            if (hi != lo) {
                val mid = mid(lo, hi)
                updateHelper(lo, mid, diff, arrIndex, 2 * index + 1)
                updateHelper(mid + 1, hi, diff, arrIndex, 2 * index + 2)
            }
        }
    }
}
