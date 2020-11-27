package dev.algos.snatch.interview_problems.matrix

import kotlin.math.abs
import kotlin.math.max


class ScoreAfterFlippingMatrix {

    fun matrixScoreOptimized(A: Array<IntArray>): Int {
        val n = A.size
        val m = A[0].size
        var res = (1 shl m - 1) * n
        for (j in 1 until m) {
            var ones = 0
            for (i in 0 until n) {
                if (A[i][0] == A[i][j]) {
                    ones++
                }
            }
            res += (1 shl (m - j - 1)) * max(ones, n - ones)
        }
        return res
    }

    fun matrixScore(A: Array<IntArray>): Int {
        val n = A.size
        val m = A[0].size
        for (i in 0 until n) {
            if (A[i][0] == 0) {
                for (j in 0 until m) {
                    A[i][j] = abs(A[i][j] - 1)
                }
            }
        }
        for (j in 1 until m) {
            var zeros = 0
            var ones = 0
            for (i in 0 until n) {
                if (A[i][j] == 0) {
                    zeros++
                } else {
                    ones++
                }
            }
            if (zeros > ones) {
                for (i in 0 until n) {
                    A[i][j] = abs(A[i][j] - 1)
                }
            }
        }
        return getSum(n, m, A)
    }

    private fun getSum(n: Int, m: Int, A: Array<IntArray>): Int {
        var sum = 0
        for (i in 0 until n) {
            var num = 0
            for (j in 0 until m) {
                num = num or (A[i][j] shl m - 1 - j)
            }
            sum += num
        }
        return sum
    }
}
