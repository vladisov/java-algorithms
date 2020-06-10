package dev.algos.snatch.interview_problems.stack;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLetters {

    /**
     * Time O(N)
     * Space O(N)
     */
    public String removeDuplicateLetters(String s) {
        int[] map = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            map[index]--;
            if (visited[index]) continue;
            while (!stack.isEmpty() && c < stack.peek() && map[stack.peek() - 'a'] >= 1) {
                char prev = stack.pop();
                visited[prev - 'a'] = false;
            }
            stack.push(c);
            visited[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
