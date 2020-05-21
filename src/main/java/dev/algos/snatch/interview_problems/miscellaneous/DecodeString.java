package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * <p>
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {

    public String decodeStringRec2(String s) {
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) queue.add(c);
        return helper(queue);
    }

    String helper(Queue<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Two stack solution
     */
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            } else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            } else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }

    /**
     * Recursive solution
     * Time O(kn)
     * Space O(levels)
     */
    public String decodeStringRec(String s) {
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
                if (Character.isDigit(s.charAt(i + 1))) continue;
                String next = getNextSub(i + 1, s);
                String decoded = decodeStringRec(next);
                for (int j = 0; j < curr; j++) {
                    sb.append(decoded);
                }
                i += next.length() + 2;
                curr = 0;
            }
        }

        return sb.toString();
    }

    String getNextSub(int i, String s) {
        int last = i + 1, open = 0;
        for (int j = i; j < s.length(); j++) {
            char b = s.charAt(j);
            if (b == '[') {
                open++;
            } else if (b == ']') {
                last = j;
                open--;
            }
            if (open == 0) break;
        }
        return s.substring(i + 1, last);
    }
}
