package dev.algos.snatch.interview_problems.tree_bfs

import java.util.LinkedList

/**
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.
Example 1:

Input: arr = [4,2,3,0,3,1,2], start = 5
Output: true
Explanation:
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
Example 2:

Input: arr = [4,2,3,0,3,1,2], start = 0
Output: true
Explanation:
One possible way to reach at index 3 with value 0 is:
index 0 -> index 4 -> index 1 -> index 3
Example 3:

Input: arr = [3,0,2,1,2], start = 2
Output: false
Explanation: There is no way to reach at index 1 with value 0.
 */
class JumpGame_III {

    /**
     * Time O(N)
     * Space O(1)
     */
    fun canReach(arr: IntArray, start: Int): Boolean {
        val queue = LinkedList<Int>()
        queue.add(start)
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val curr = queue.poll()
                if (arr[curr] < 0) continue
                if (arr[curr] == 0) return true
                val next = curr + arr[curr]
                val prev = curr - arr[curr]
                if (next < arr.size && arr[next] >= 0) {
                    queue.add(next)
                }
                if (prev >= 0 && arr[prev] >= 0) {
                    queue.add(prev)
                }
                arr[curr] = -arr[curr]
            }
        }
        return false
    }

    /**
     * Time O(N)
     * Space O(1)
     */
    fun canReachDFS(arr: IntArray, start: Int): Boolean {
        if (start < 0 || start >= arr.size || arr[start] < 0) return false
        if (arr[start] == 0) return true
        val next = start + arr[start]
        val prev = start - arr[start]
        arr[start] = -arr[start]
        return canReachDFS(arr, next) || canReachDFS(arr, prev)
    }
}
