package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 * <p>
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 * <p>
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 * <p>
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 * <p>
 * Input: num = "3456237490", target = 9191
 * Output: []
 */
public class AddOperators {

    /**
     * Time O(4^N) 4th for no operator
     */
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) return result;
        backtrack(result, num, "", 0, 0, target, 0);
        return result;
    }

    private void backtrack(List<String> result, String num, String path, int index, long eval, long target, long multed) {
        if (eval == target && index == num.length()) {
            result.add(path);
        } else {
            long curr = 0;
            for (int i = index; i < num.length(); i++) {
                if (i != index && num.charAt(index) == '0') break;
                curr = num.charAt(i) - '0' + curr * 10;
                if (index == 0) {
                    backtrack(result, num, path + curr, i + 1, curr, target, curr);
                } else {
                    backtrack(result, num, path + "+" + curr, i + 1, eval + curr, target, curr);
                    backtrack(result, num, path + "-" + curr, i + 1, eval - curr, target, -curr);
                    backtrack(result, num, path + "*" + curr, i + 1, eval - multed + multed * curr, target, multed * curr);
                }
            }
        }
    }
}
