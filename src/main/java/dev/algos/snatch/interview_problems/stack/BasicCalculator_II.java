package dev.algos.snatch.interview_problems.stack;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: "3+2*2"
 * Output: 7
 * Example 2:
 * <p>
 * Input: " 3/2 "
 * Output: 1
 * Example 3:
 * <p>
 * Input: " 3+5 / 2 "
 * Output: 5
 */
public class BasicCalculator_II {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0'; // for
            }
            if (i == s.length() - 1 || !Character.isDigit(c)) {
                switch (sign) {
                    case '-':
                        stack.push(-num);
                        break;
                    case '+':
                        stack.push(num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = c;
            }
        }
        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }

    /**
     * Time O(N)
     * Space O(1)
     */
    int evaluate(String s) {
        if (s.isEmpty()) return 0;
        s = s.replaceAll("\\s+", "");
        int total = 0, num = 0, top = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (i == s.length() - 1 || !Character.isDigit(c)) {
                if (operator == '/') {
                    top = top / num;
                } else if (operator == '*') {
                    top = top * num;
                } else if (operator == '+') {
                    total += top;
                    top = num;
                } else {
                    total += top;
                    top = -num;
                }
                operator = c;
                num = 0;
            }
        }
        return total + top;
    }

}
