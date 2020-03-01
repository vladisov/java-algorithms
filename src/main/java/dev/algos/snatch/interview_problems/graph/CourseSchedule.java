package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 */
public class CourseSchedule {

    /**
     * Time complexity O(N) or O(V + E) ?
     * Space complexity O(N)
     */
    public int[] findOrder(int numCourses, int[][] pre) {
        if (numCourses <= 0) {
            return new int[0];
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < pre.length; i++) {
            indegree[pre[i][1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);
            for (int[] preNode : pre) {
                if (preNode[0] == node) {
                    int adj = preNode[1];
                    if (--indegree[adj] == 0) {
                        queue.add(adj);
                    }
                }
            }
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != 0)
                return new int[0];
        }
        Collections.reverse(list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
