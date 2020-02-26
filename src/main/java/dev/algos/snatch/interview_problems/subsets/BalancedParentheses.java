package dev.algos.snatch.interview_problems.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class BalancedParentheses {

    /**
     * Time complexity O(N*2^N)
     * Space complexity O(N*2^N) ?
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, n, 0, 0, new StringBuilder());

        return result;
    }

    private void backtrack(List<String> result, int n, int left, int right, StringBuilder sb) {
        if (left == right && left == n) {
            result.add(sb.toString());
        }
        if (left < n) {
            sb.append("(");
            backtrack(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtrack(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> generateParenthesisBfs(int n) {
        List<String> result = new ArrayList<>();
        Queue<Parenthesis> queue = new LinkedList<>();
        queue.add(new Parenthesis(1, 0, "("));
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if (curr.left == n && curr.left == curr.right) {
                result.add(curr.val);
            }
            if (curr.left < n) {
                queue.add(new Parenthesis(curr.left + 1, curr.right, curr.val + "("));
            }
            if (curr.right < curr.left) {
                queue.add(new Parenthesis(curr.left, curr.right + 1, curr.val + ")"));
            }
        }
        return result;
    }

    static class Parenthesis {
        int left;
        int right;
        String val;

        public Parenthesis(int left, int right, String val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
