package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */
public class MinimumNumberToRemoveParentheses {

    /**
     * Naive solution
     * Time O(2^N)
     * Space O(N) ?
     */
    public static List<String> removeInvalidParenthesesNaive(String s) {
        Set<String> result = new HashSet<>();
        removeRec(s, 0, result, "", 0, 0);
        int max = 0;
        for (String res : result) {
            max = Math.max(res.length(), max);
        }
        int finalMax = max;
        return result.stream().filter(str -> str.length() == finalMax).collect(Collectors.toList());
    }

    private static void removeRec(String s, int index, Set<String> result, String tmp, int left, int right) {
        if (index == s.length() && left == right) {
            result.add(tmp);
            return;
        } else if (index == s.length()) {
            return;
        }
        if (s.charAt(index) == '(') {
            removeRec(s, index + 1, result, tmp + s.charAt(index), left + 1, right);
        } else if (s.charAt(index) == ')' && left > right) {
            removeRec(s, index + 1, result, tmp + s.charAt(index), left, right + 1);
        } else if (Character.isLetter(s.charAt(index))) {
            removeRec(s, index + 1, result, tmp + s.charAt(index), left, right);
        }
        removeRec(s, index + 1, result, tmp, left, right);
    }


    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        Set<String> set = new HashSet<>();
        dfs(s, 0, left, right, 0, new StringBuilder(), set);
        return new ArrayList<>(set);
    }

    private void dfs(String s, int i, int left, int right, int open, StringBuilder sb, Set<String> result) {
        if (left < 0 || right < 0 || open < 0) {
            return;
        }
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(i);
        if (c == '(') {
            dfs(s, i + 1, left - 1, right, open + 1, sb, result);
            dfs(s, i + 1, left, right, open, sb.append(c), result);
        } else if (c == ')') {
            dfs(s, i + 1, left, right - 1, open - 1, sb, result);
            dfs(s, i + 1, left, right, open, sb.append(c), result);
        } else {
            dfs(s, i + 1, left, right, open, sb.append(c), result);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
