package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 */
public class ValidParenthesis {

    /**
     * Time O(N)
     * Space O(1)
     */
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        int rangeStart = 0, rangeEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                rangeStart++;
                rangeEnd++;
            } else if (c == ')') {
                //cannot recover from negative
                rangeStart = Math.max(0, rangeStart - 1);
                rangeEnd--;
            } else {
                rangeStart = Math.max(0, rangeStart - 1);
                rangeEnd++;
            }
            if (rangeEnd < 0) return false;
        }
        return rangeStart <= 0 && rangeEnd >= 0;
    }
}
