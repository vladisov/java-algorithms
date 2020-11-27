package dev.algos.snatch.interview_problems.stack

import kotlin.math.max

class LongestSubarrayWithASumAtMostK {

    /*
    5, -10, 7, -20, 57 -22
    ans = -10 7 -22 = 3 (sum = -23)

    0 5 -5 2 -18 39 = -18 - 5 = prefix[end + 1] - prefix[start]
     */
    fun longestSumArray(arr: IntArray, k: Int): Int {
        var sum = 0;
        var ans = 0;
        val n = arr.size
        val prefixes = IntArray(n)
        for (i in 0 until n) {
            sum += arr[i]
            if (sum <= k) {
                ans = i + 1
            } else {
                while (i - ans > 0 && sum - prefixes[i - ans - 1] <= k) ans++
                if (i == 0) {
                    prefixes[i] = sum
                } else {
                    prefixes[i] = max(prefixes[i - 1], sum)
                }
            }
        }
        return ans
    }

}
