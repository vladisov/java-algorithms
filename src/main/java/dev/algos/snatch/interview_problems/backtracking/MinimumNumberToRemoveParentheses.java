package dev.algos.snatch.interview_problems.backtracking;

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
        return List.of();
    }
}
