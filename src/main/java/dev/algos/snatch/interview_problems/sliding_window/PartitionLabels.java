package dev.algos.snatch.interview_problems.sliding_window;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

    /**
     * Time O(N)
     * Space O(N)
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            set.add(c);
            map[c - 'a']--;
            if (map[c - 'a'] == 0) {
                set.remove(c);
            }
            end++;
            if (set.size() == 0) {
                result.add(end - start);
                start = end;
            }
        }
        return result;
    }
}
