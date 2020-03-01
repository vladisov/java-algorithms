package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an expression containing digits and operations (+, -, *),
 * find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
 * Example 2:
 * <p>
 * Input: "2*3-4-5"
 * Output: 8, -12, 7, -7, -3
 * Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3
 */
public class EvaluateExpression {

    /**
     * Time complexity O(2^N)
     * Space complexity O(2^N)
     */
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("-") && !input.contains("+") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!Character.isDigit(c)) {
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                    for (int leftNum : left) {
                        for (var rightNum : right) {
                            if (c == '-') {
                                result.add(leftNum - rightNum);
                            } else if (c == '+') {
                                result.add(leftNum + rightNum);
                            } else if (c == '*') {
                                result.add(leftNum * rightNum);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
