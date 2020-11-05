package dev.algos.snatch.interview_problems.backtracking;

import java.util.HashSet;
import java.util.Set;

public class CrackSafe {

    /**
     * de bruijn sequence :O
     * Time O(k^n)
     * Space O(k^n)
     */
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('0');
        int total = (int) Math.pow(k, n);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        helper(n, k, visited, sb, total);
        return sb.toString();
    }

    private boolean helper(int n, int k, Set<String> visited, StringBuilder sb, int total) {
        if (total == visited.size()) {
            return true;
        }
        String prev = sb.substring(sb.length() - n + 1);
        for (int i = 0; i < k; i++) {
            String next = prev + i;
            if (!visited.contains(next)) {
                visited.add(next);
                sb.append(i);
                if (helper(n, k, visited, sb, total)) return true;
                visited.remove(next);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}
