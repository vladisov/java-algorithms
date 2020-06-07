package dev.algos.snatch.interview_problems.tree_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company has is the one with headID.
 * <p>
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also it's guaranteed that the subordination relationships have a tree structure.
 * <p>
 * The head of the company wants to inform all the employees of the company of an urgent piece of news. He will inform his direct subordinates and they will inform their subordinates and so on until all employees know about the urgent news.
 * <p>
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
 * <p>
 * Return the number of minutes needed to inform all the employees about the urgent news.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 */
public class TimeToInformAllEmployees {

    /**
     * Bfs
     * Time O(V + E) where V number of employees and E number of connections
     * Space O(V)
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            map.putIfAbsent(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{headID, 0});
        int max = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] data = queue.poll();
                int man = data[0];
                int time = data[1];
                if (map.containsKey(man) && !map.get(man).isEmpty()) {
                    for (int emp : map.get(man)) {
                        queue.add(new int[]{emp, time + informTime[man]});
                    }
                }
                max = Math.max(time, max);

            }
        }
        return max;
    }
}
