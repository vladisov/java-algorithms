package dev.algos.snatch.interview_problems.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//TODO sdelal huinyu
public class Sudoku {

    boolean sudoku2(char[][] grid) {
        int n = grid.length;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < n - 3; i++) {
            map.clear();
            if (!addFirstGrid(grid, map, i)) {
                return false;
            }
            for (int j = 3; j < n; j++) {
                if (!appendRow(grid, map, j, i)) {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean appendRow(char[][] grid, Map<Integer, Set<Character>> map, int row, int col) {
        map.remove(0);
        for (int k = 0; k < 2; k++) {
            map.put(k, map.get(k + 1));
        }
        map.remove(2);
        int n = col + 3;
        while (col < n) {
            char c = grid[row][col++];
            if (c != '.') {
                if (contains(map, c)) {
                    return false;
                } else {
                    map.computeIfAbsent(2, (index) -> new HashSet<>()).add(c);
                }
            } else if (!map.containsKey(2)) {
                map.put(2, new HashSet<>());
            }
        }
        return true;
    }


    private boolean addFirstGrid(char[][] grid, Map<Integer, Set<Character>> map, int col) {
        int n = col + 3;
        for (int i = 0; i < 3; i++) {
            for (int j = col; j < n; j++) {
                char c = grid[i][j];
                if (c != '.') {
                    if (contains(map, c)) {
                        return false;
                    } else {
                        map.computeIfAbsent(i, (index) -> new HashSet<>()).add(c);
                    }
                } else if (!map.containsKey(i)) {
                    map.put(i, new HashSet<>());
                }
            }
        }
        return true;
    }

    private boolean contains(Map<Integer, Set<Character>> map, char c) {
        if (map.isEmpty()) {
            return false;
        }
        for (Set<Character> set : map.values()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }

}
