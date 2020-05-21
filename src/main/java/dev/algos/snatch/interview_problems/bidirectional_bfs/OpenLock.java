package dev.algos.snatch.interview_problems.bidirectional_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 */
public class OpenLock {

    private static List<String> getAdjacentNodes(String node) {
        List<String> nodes = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            int c = node.charAt(j) - '0';
            nodes.add(node.substring(0, j) + (c == 9 ? 0 : c + 1) + node.substring(j + 1));
            nodes.add(node.substring(0, j) + (c == 0 ? 9 : c - 1) + node.substring(j + 1));
        }
        return nodes;
    }

    /**
     * Time & Space O(b^(d/2))
     */
    public int openLockBidirectional(String[] deadends, String target) {
        Set<String> blocks = new HashSet<>();
        Collections.addAll(blocks, deadends);
        String start = "0000";
        if (blocks.contains(start)) return -1;
        if (start.equals(target)) return 0;

        Set<String> beginSet = new HashSet<>() {{
            add(start);
        }};
        Set<String> endSet = new HashSet<>() {{
            add(target);
        }};

        int lvl = 0;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            lvl++;
            //always pick smallest
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> tmp = new HashSet<>();
            for (String node : beginSet) {
                for (String adj : getAdjacentNodes(node)) {
                    if (!blocks.contains(adj)) {
                        tmp.add(adj);
                        blocks.add(node);
                        if (endSet.contains(adj)) {
                            return lvl;
                        }
                    }
                }
            }
            beginSet = tmp;
        }
        return -1;
    }

    /**
     * Time O(V + E) -> can say it's constant
     * Space O(V)
     * Basic bfs approach
     */
    public int openLock(String[] deadends, String target) {
        Set<String> blocks = new HashSet<>();
        Collections.addAll(blocks, deadends);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if (blocks.contains(start)) return -1;
        if (start.equals(target)) return 0;
        queue.add(start);
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return lvl;
                }
                List<String> adjList = getAdjacentNodes(node);
                for (String adj : adjList) {
                    if (!visited.contains(adj) && !blocks.contains(adj)) {
                        visited.add(adj);
                        queue.add(adj);
                    }
                }
            }
            lvl++;
        }
        return -1;
    }
}
