package dev.algos.snatch.interview_problems.backtracking

fun judgePoint24(nums: IntArray): Boolean {
    return judge(nums, 0, 0, 0.0, false)
}

fun judge(nums: IntArray, index: Int, used: Int, sum: Double, positive: Boolean): Boolean {
    if (index == 4) {
        if (positive && sum < 24 && 24 - sum < 3) println(sum)
        if (positive && sum == 24.0) return true
        return false
    }
    for (i in nums.indices) {
        if ((used and (1 shl i)) != 0) continue
        val useNum = used or (1 shl i)
        if (judge(nums, index + 1, useNum, sum - nums[i], positive) ||
            judge(nums, index + 1, useNum, sum + nums[i], true) ||
            judge(nums, index + 1, useNum, sum / nums[i], positive) ||
            judge(nums, index + 1, useNum, sum * nums[i], positive)
        ) {
            return true
        }
    }
    return false
}

fun main() {
    println(judgePoint24(intArrayOf(1, 9, 1, 2)))
//    println(judgePoint24(intArrayOf(4, 1, 8, 2)))
//    println(judgePoint24(intArrayOf(1, 2, 1, 2)))
//    println(judgePoint24(intArrayOf(4, 1, 2, 3)))
}


/*
4 / (1 - 2/3)

(- 2 / 3 + 1 )* 1/4
 */
