package dev.algos.snatch.interview_problems.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * You have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible non-empty sequences of letters you can make.
 * Example 1:
 * Input: "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 * Input: "AAABBC"
 * Output: 188
 */
public class NumberOfTiles {

    /**
     * Naive backtracking subsets
     * Time O(N!)
     * Space O(N) recursion stack
     */
    public int numOfTiles(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        return dfs(map);
    }

    private int dfs(int[] map) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) continue;
            count++;
            map[i]--;
            count += dfs(map);
            map[i]++;
        }
        return count;
    }

    /**
     * Naive backtracking subsets
     * Time O(N!)
     * Space O(N!)
     */
    public int numOfTilesSubsets(String s) {
        Set<String> sets = new HashSet<>();
        backtrack(s, new StringBuilder(), sets, new HashSet<>());
        return sets.size();
    }

    private void backtrack(String s, StringBuilder sb,
                           Set<String> sets, Set<Integer> visited) {
        if (sb.length() > s.length()) {
            return;
        }
        if (sb.length() > 0) {
            sets.add(sb.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited.contains(i)) continue;
            sb.append(s.charAt(i));
            visited.add(i);
            backtrack(s, sb, sets, visited);
            visited.remove(i);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
