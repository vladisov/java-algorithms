package dev.algos.snatch.interview_problems.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/basic-calculator-iii/
 */
public class BasicCalculator_III {

    /**
     * Time O(N)
     * Space O(1) or (N) if brackets + recursion tree
     */
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.add(c);
        return evaluate(queue);
    }

    int evaluate(Queue<Character> queue) {
        if (queue.isEmpty()) return 0;
        int total = 0, num = 0, top = 0;
        char operator = '+';
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = evaluate(queue);
            } else if (c == ')') {
                return total + top;
            }
            if (queue.isEmpty() || !Character.isDigit(c) || (!queue.isEmpty() && queue.peek() == ')')) {
                if (operator == '/') {
                    top = top / num;
                } else if (operator == '*') {
                    top = top * num;
                } else if (operator == '+') {
                    total += top;
                    top = num;
                } else if (operator == '-') {
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
