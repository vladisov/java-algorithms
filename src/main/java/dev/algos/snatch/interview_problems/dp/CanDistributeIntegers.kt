package dev.algos.snatch.interview_problems.dp

import java.util.Arrays
import java.util.TreeMap

class CanDistributeIntegers {

    fun canDistribute(nums: IntArray, quantity: IntArray): Boolean {
        val valueToCount = mutableMapOf<Int, Int>()
        val countToValue = TreeMap<Int, MutableSet<Int>>()
        for (num in nums) valueToCount[num] = valueToCount.getOrDefault(num, 0) + 1
        for ((num, count) in valueToCount) {
            countToValue.putIfAbsent(count, HashSet())
            countToValue[count]!!.add(num)
        }
        Arrays.sort(quantity)
        return helper(quantity.size - 1, countToValue, quantity)
    }

    fun helper(qIndex: Int, countToValue: TreeMap<Int, MutableSet<Int>>, quantity: IntArray): Boolean {
        if (qIndex < 0) return true
        val countValueList = mutableListOf<IntArray>()
        for ((count, valueSet) in countToValue.tailMap(quantity[qIndex])) {
            for (value in valueSet) {
                countValueList.add(intArrayOf(count, value))
            }
        }
        for ((count, value) in countValueList) {
            countToValue[count]!!.remove(value)
            countToValue.putIfAbsent(count - quantity[qIndex], HashSet())
            countToValue[count - quantity[qIndex]]!!.add(value)
            if (helper(qIndex - 1, countToValue, quantity) || (count - quantity[qIndex] >= quantity[qIndex] && helper(qIndex, countToValue, quantity))) return true
            countToValue[count]!!.add(value)
            countToValue[count - quantity[qIndex]]!!.remove(value)
        }
        return false
    }

    fun canDistributeOptimized(nums: IntArray, quantity: IntArray): Boolean {
        val valueToCount = mutableMapOf<Int, Int>()
        for (num in nums) valueToCount[num] = valueToCount.getOrDefault(num, 0) + 1
        val countMap = IntArray(valueToCount.size)
        for ((index, count) in valueToCount.values.withIndex()) {
            countMap[index] = count
        }
        Arrays.sort(quantity)
        return helperOptimized(quantity.size - 1, countMap, quantity)
    }

    private fun helperOptimized(qIndex: Int, countMap: IntArray, quantity: IntArray): Boolean {
        if (qIndex < 0) return true
        for (i in countMap.indices) {
            if (countMap[i] >= quantity[qIndex]) {
                countMap[i] -= quantity[qIndex]
                if (helperOptimized(qIndex - 1, countMap, quantity)) return true
                countMap[i] += quantity[qIndex]
            }
        }
        return false
    }
}
