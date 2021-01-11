package dev.algos.snatch.interview_problems.prefix_sum

/**
 * Time O(N)
 * Space O(N)
 */
fun maxNonOverlapping(nums: IntArray, target: Int): Int {
    var sum = 0
    var count = 0
    var prefix = mutableSetOf(0)
    for (num in nums) {
        sum += num
        if (prefix.contains(sum - target)) {
            count++
            prefix = mutableSetOf()
            sum = 0
        }
        prefix.add(sum)
    }
    return count
}
