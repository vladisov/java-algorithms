package dev.algos.snatch.interview_problems.dp

fun canMouseWin(grid: Array<String>, catJump: Int, mouseJump: Int): Boolean {
    val (mi, mj, ci, cj) = getCatMouseIndices(grid)
    val n = grid.size
    val m = grid[0].length
    val dp = Array(n * m) { Array(n * m) { Array(2) { Array<Boolean?>(1001) { null } } } }
    return solve(grid, catJump, mouseJump, ci, cj, mi, mj, 0, 0, dp)
}

var dirs = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(-1, 0))
fun solve(
    grid: Array<String>, catJump: Int, mouseJump: Int, ci: Int, cj: Int,
    mi: Int, mj: Int, turn: Int, turns: Int, dp: Array<Array<Array<Array<Boolean?>>>>
): Boolean {
    if (turns > 1000) return false
    if (dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] != null) {
        return dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns]!!
    }
    val ans = turn != 0
    if (turn == 0) {
        for (dir in dirs) {
            for (jump in 0..mouseJump) {
                val ni = dir[0] * jump + mi
                val nj = dir[1] * jump + mj
                if (isValid(ni, nj, grid)) {
                    if (grid[ni][nj] == 'F') {
                        dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] = true
                        return true
                    }
                    if (grid[ni][nj] == 'C') continue
                    updateGrid(mi, mj, ni, nj, true, grid)
                    if (solve(grid, catJump, mouseJump, ci, cj, ni, nj, 1, turns + 1, dp)) {

                        updateGrid(ni, nj, mi, mj, true, grid)
                        dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] = true
                        return true
                    }
                    updateGrid(ni, nj, mi, mj, true, grid)
                } else break
            }
        }
    } else {
        for (dir in dirs) {
            for (jump in 0..catJump) {
                val ni = dir[0] * jump + ci
                val nj = dir[1] * jump + cj
                if (isValid(ni, nj, grid)) {
                    if (grid[ni][nj] == 'F' || grid[ni][nj] == 'M') {
                        dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] = false
                        return false
                    }
                    updateGrid(ci, cj, ni, nj, false, grid)
                    if (!solve(grid, catJump, mouseJump, ni, nj, mi, mj, 0, turns + 1, dp)) {
                        updateGrid(ni, nj, ci, cj, false, grid)
                        dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] = false
                        return false
                    }
                    updateGrid(ni, nj, ci, cj, false, grid)

                } else break
            }
        }
    }
    dp[toIndex(mi, mj, grid)][toIndex(ci, cj, grid)][turn][turns] = ans
    return ans
}

fun updateGrid(row: Int, col: Int, nextRow: Int, nextCol: Int, isMouse: Boolean, grid: Array<String>) {
    val chs = grid[row].toCharArray()
    chs[col] = '.'
    grid[row] = String(chs)

    val chsNext = grid[nextRow].toCharArray()
    chsNext[nextCol] = if (isMouse) 'M' else 'C'
    grid[nextRow] = String(chsNext)
}

fun isValid(i: Int, j: Int, grid: Array<String>): Boolean {
    return i >= 0 && j >= 0 && i < grid.size && j < grid[0].length && grid[i][j] != '#'
}

private fun getCatMouseIndices(grid: Array<String>): IntArray {
    var ci = 0
    var cj = 0
    var mi = 0
    var mj = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 'C') {
                ci = i
                cj = j
            } else if (grid[i][j] == 'M') {
                mi = i
                mj = j
            }
        }
    }
    return intArrayOf(mi, mj, ci, cj)
}

private fun toIndex(i: Int, j: Int, grid: Array<String>) = i * grid[0].length + j
