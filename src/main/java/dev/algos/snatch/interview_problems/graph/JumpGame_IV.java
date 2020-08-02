package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an array of integers arr, you are initially positioned at the first index of the array.
 * <p>
 * In one step you can jump from index i to index:
 * <p>
 * i + 1 where: i + 1 < arr.length.
 * i - 1 where: i - 1 >= 0.
 * j where: arr[i] == arr[j] and i != j.
 * Return the minimum number of steps to reach the last index of the array.
 * <p>
 * Notice that you can not jump outside of the array at any time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
 * Output: 3
 * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
 * Example 2:
 * <p>
 * Input: arr = [7]
 * Output: 0
 * Explanation: Start index is the last index. You don't need to jump.
 * Example 3:
 * <p>
 * Input: arr = [7,6,9,6,9,6,9,7]
 * Output: 1
 * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 * Example 4:
 * <p>
 * Input: arr = [6,1,9]
 * Output: 2
 * Example 5:
 * <p>
 * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
 * Output: 3
 */
public class JumpGame_IV {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int minJumps(int[] arr) {
        if (arr.length == 1) return 0;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new Stack<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        int lvl = 0;
        boolean[] visited = new boolean[arr.length];
        while (!queue.isEmpty()) {
            lvl++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                Stack<Integer> stack = map.get(arr[index]);
                while (!stack.isEmpty()) {
                    int adj = stack.pop();
                    if (adj == arr.length - 1) {
                        return lvl;
                    }
                    if (!visited[adj]) {
                        queue.add(adj);
                        visited[adj] = true;
                    }
                }
                int left = index - 1;
                int right = index + 1;
                if (right == arr.length - 1) {
                    return lvl;
                }
                if (left > 0) {
                    if (!visited[left]) {
                        queue.add(left);
                        visited[left] = true;
                    }
                }
                if (right < arr.length) {
                    if (!visited[right]) {
                        queue.add(right);
                        visited[right] = true;
                    }
                }
            }
        }
        return lvl;
    }
}
