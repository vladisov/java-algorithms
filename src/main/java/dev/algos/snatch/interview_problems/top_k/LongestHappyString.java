package dev.algos.snatch.interview_problems.top_k;

import java.util.PriorityQueue;

/**
 * A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.
 * <p>
 * Given three integers a, b and c, return any string s, which satisfies following conditions:
 * <p>
 * s is happy and longest possible.
 * s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
 * s will only contain 'a', 'b' and 'c' letters.
 * If there is no such string s return the empty string "".
 */
public class LongestHappyString {

    /**
     * Time O(Nlog3) = O(N)
     * Space O(3) = O(1) except string builder that is O(N)
     */
    public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[3];
        count[0] = a;
        count[1] = b;
        count[2] = c;
        PriorityQueue<Character> queue = new PriorityQueue<>((i, j) -> count[j - 'a'] - count[i - 'a']);
        for (char i = 'a'; i <= 'c'; i++) {
            if (count[i - 'a'] != 0) {
                queue.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch) {
                char tmp = ch;
                if (queue.size() > 0) {
                    ch = queue.poll();
                } else {
                    break;
                }
                queue.add(tmp);
            }
            count[ch - 'a']--;
            sb.append(ch);
            if (count[ch - 'a'] > 0) {
                queue.add(ch);
            }
        }
        return sb.toString();
    }
}
