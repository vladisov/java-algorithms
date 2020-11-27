package dev.algos.snatch.interview_problems.backtracking

import kotlin.math.max
import kotlin.math.pow

class MaximizeGridHappiness {

    //TODO fix
    fun getMaxGridHappiness(n: Int, m: Int, introvertsCount: Int, extrovertsCount: Int): Int {
        return helper(0, 0, n, m, introvertsCount, extrovertsCount, 0,
                Array(n) { Array(m) { Array(introvertsCount + 1) { Array(extrovertsCount + 1) { IntArray(243) } } } })
    }

    private fun helper(x: Int, y: Int, n: Int, m: Int, iCount: Int, eCount: Int, prevM: Int, dp: Array<Array<Array<Array<IntArray>>>>): Int {
        if (y == m) {
            return helper(x + 1, 0, n, m, iCount, eCount, prevM, dp)
        }
        if (x == n || (eCount == 0 && iCount == 0)) {
            return 0
        }
        if (dp[x][y][iCount][eCount][prevM] != 0) {
            return dp[x][y][iCount][eCount][prevM]
        }
        var result = helper(x, y + 1, n, m, iCount, eCount, set(prevM, 0), dp)
        val left = get(prevM, 0)
        val up = get(prevM, m - 1)

        if (iCount > 0) {
            val newMState = set(prevM, 1)
            var addOn = 120
            if (x - 1 >= 0 && up != 0) {
                addOn -= 30 // for current
                if (up == 1) {
                    addOn -= 30 //for prev
                } else {
                    addOn += 20
                }
            }
            if (y - 1 >= 0 && left != 0) {
                addOn -= 30 // for current
                if (up == 1) {
                    addOn -= 30 //for prev
                } else {
                    addOn += 20
                }
            }
            result = max(result, helper(x, y + 1, n, m, iCount - 1, eCount, newMState, dp) + addOn)
        }
        if (eCount > 0) {
            val newMState = set(prevM, 2)
            var addOn = 40
            if (x - 1 >= 0 && up != 0) {
                addOn += 20
                if (up == 1) {
                    addOn -= 30 //for prev
                } else {
                    addOn += 20
                }
            }
            if (y - 1 >= 0 && left != 0) {
                addOn += 20
                if (up == 1) {
                    addOn -= 30 //for prev
                } else {
                    addOn += 20
                }
            }
            result = max(result, helper(x, y + 1, n, m, iCount, eCount - 1, newMState, dp) + addOn)
        }
        dp[x][y][iCount][eCount][prevM] = result
        return dp[x][y][iCount][eCount][prevM]
    }

    // Ternary get ith bit value (0, 1 or 2)
    private fun get(prevM: Int, i: Int): Int {
        val state = prevM / 3.0.pow(i.toDouble()).toInt()
        return state % 3
    }

    // Ternary set new-coming bit to value
    private fun set(currRow: Int, value: Int): Int {
        return (currRow * 3 + value) % 243
    }
}
