package dev.algos.snatch.interview_problems.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * <p>
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * <p>
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * <p>
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 */
public class SlidingPuzzle {


    /**
     * Time (R * C)! - number of board states & RC for copy of the board ->  RC * RC! -> 3 * 2 * (3 * 2)!
     * Space RC * RC!
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                start += board[i][j];
            }
        }
        if (target.equals(start)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int lvl = 0;

        int[][] dirs = new int[][]{
                {1, 3},
                {0, 2, 4},
                {1, 5},
                {0, 4},
                {1, 3, 5},
                {2, 4}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                visited.add(curr);
                if (target.equals(curr)) {
                    return lvl;
                }
                int index = curr.indexOf('0');
                for (int dir : dirs[index]) {
                    String next = getNext(curr, index, dir);
                    if (!visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
            lvl++;
        }
        return -1;
    }

    private String getNext(String curr, int i, int dir) {
        char[] s = curr.toCharArray();
        char tmp = s[i];
        s[i] = s[dir];
        s[dir] = tmp;
        return new String(s);
    }
}
