package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 * Example 2:
 * <p>
 * Input: String="abbcb", k=1
 * Output: 4
 * Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
 * Example 3:
 * <p>
 * Input: String="abccde", k=1
 * Output: 3
 * Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
 */
public class CharacterReplacement {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(1) lowercase only 26
     * As we are expecting only the lower case letters in the input string, we can conclude that the space complexity will be O(26)
     * , to store each letter’s frequency in the HashMap, which is asymptotically equal to O(1).
     */
    public int findLength(String s, int k) {
        if (s == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, max = 0, uniqueCount = 0;
        while (end < s.length()) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            uniqueCount = Math.max(uniqueCount, map.get(s.charAt(end)));
            end++;
            int replacementCount = end - start - uniqueCount;
            if (replacementCount > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            } else {
                max = Math.max(max, end - start);
            }
        }
        return max;
    }

    int findLength1(String str, int k) {
        if (str == null) return 0;
        int windowStart = 0, max = 0, maxRepeatLetterCount = 0;
        Map<Character, Integer> letterFrequencyMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            var c = str.charAt(i);
            letterFrequencyMap.put(c, letterFrequencyMap.getOrDefault(c, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(c));

            if (i - windowStart + 1 - maxRepeatLetterCount > k) {
                var charAtStart = str.charAt(windowStart);
                letterFrequencyMap.put(charAtStart, letterFrequencyMap.get(charAtStart) - 1);
                windowStart++;
            }
            max = Math.max(max, i - windowStart + 1);
        }
        return max;
    }
}
