package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.pow

class AtMostNGivenSet {
    fun atMostNGivenDigitSet(digits: Array<String>, n: Int): Int {
        return helper(n.toString(), digits)
    }

    private fun helper(n: String, digits: Array<String>): Int {

        var total = 0
        for (i in 1 until n.length) {
            total += digits.size.toDouble().pow(i).toInt()
        }
        val dp = IntArray(n.length + 1)
        dp[n.length] = 1
        var i = n.length - 1
        while (i >= 0) {
            val num = n[i] - '0'
            for (digit in digits) {
                if (digit.toInt() < num) {
                    dp[i] += digits.size.toDouble().pow(n.length - i - 1).toInt()
                } else if (digit.toInt() == num) {
                    dp[i] += dp[i + 1]
                }
            }
            i--
        }
        return dp[0] + total
    }
    /*
    ["2","3","4","6","8"]
    61

    1 4

    1 4
    4 1
    1 1
    4 4
     */
}
