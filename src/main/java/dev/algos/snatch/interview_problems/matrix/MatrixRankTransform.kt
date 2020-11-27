package dev.algos.snatch.interview_problems.matrix

import java.util.LinkedList
import java.util.TreeMap
import kotlin.math.max


/**
 * Given an m x n matrix, return a new matrix answer where answer[row][col] is the rank of matrix[row][col].

The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:

The rank is an integer starting from 1.
If two elements p and q are in the same row or column, then:
If p < q then rank(p) < rank(q)
If p == q then rank(p) == rank(q)
If p > q then rank(p) > rank(q)
The rank should be as small as possible.
It is guaranteed that answer is unique under the given rules.
 */
class MatrixRankTransform {

    /**
     * Time O(NMlogNM)
     * Space O(NM)
     */
    fun matrixRankTransform(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size;
        val m = matrix[0].size
        val graphs = mutableMapOf<Int, MutableMap<Int, MutableList<Int>>>()
        // build neighbor rows and cols , ~ to get negative and fit in one map
        for (i in 0 until n) {
            for (j in 0 until m) {
                val v = matrix[i][j]
                graphs.putIfAbsent(v, mutableMapOf())
                val graph = graphs[v]!!
                graph.putIfAbsent(i, mutableListOf())
                graph.putIfAbsent(j.inv(), mutableListOf())
                graph[i]!!.add(j.inv())
                graph[j.inv()]!!.add(i)
            }
        }

        val value2index = TreeMap<Int, MutableList<MutableList<IntArray>>>()
        val seen = Array(n) { BooleanArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (seen[i][j]) continue
                val value = matrix[i][j]
                val graph = graphs[value]!!
                val rowCols = mutableSetOf<Int>()
                rowCols.add(i)
                rowCols.add(j.inv())

                // collect all neighbors indices
                val queue = LinkedList<Int>()
                queue.add(i)
                queue.add(j.inv())
                while (!queue.isEmpty()) {
                    val node = queue.poll()
                    for (nei in graph[node]!!) {
                        if (!rowCols.contains(nei)) {
                            rowCols.add(nei)
                            queue.add(nei)
                        }
                    }
                }

                // build all points
                val points = mutableListOf<IntArray>()
                for (rowCol in rowCols) {
                    for (k in graph[rowCol]!!) {
                        if (k >= 0) {
                            points.add(intArrayOf(k, rowCol.inv()))
                            seen[k][rowCol.inv()] = true
                        } else {
                            points.add(intArrayOf(rowCol, k.inv()))
                            seen[rowCol][k.inv()] = true
                        }
                    }
                }
                value2index.putIfAbsent(value, mutableListOf()) // neighbour points
                value2index[value]!!.add(points)
            }
        }
        val ans = Array(n) { IntArray(m) };
        val rowMax = IntArray(n)
        val colMax = IntArray(m)
        for (v in value2index.keys) {
            for (points in value2index[v]!!) {
                var rank = 1
                // first get max ranks for all neighbor points
                for (point in points) {
                    rank = max(rank, max(rowMax[point[0]], colMax[point[1]]) + 1)
                }
                for (point in points) {
                    ans[point[0]][point[1]] = rank
                    rowMax[point[0]] = max(rank, rowMax[point[0]])
                    colMax[point[1]] = max(rank, colMax[point[1]])
                }
            }
        }
        return ans
    }
}
