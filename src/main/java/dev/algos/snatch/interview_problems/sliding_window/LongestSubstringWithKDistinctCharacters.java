package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 * Example 2:
 * <p>
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 * Example 3:
 * <p>
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringWithKDistinctCharacters {


    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N) where ‘N’ is the number of characters in the input string.
     * The outer for loop runs for all characters and the inner while loop processes each character only once,
     * therefore the time complexity of the algorithm will be O(N+N) which is asymptotically equivalent to O(N).
     * O(n)
     * <p>
     * Space Complexity
     * The space complexity of the algorithm is O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
     * O(k)
     */
    public int findLength(String str, int k) {
        if (str == null || str.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int end = 0, start = 0, len = 0;
        while (end < str.length()) {
            char endChar = str.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            end++;
            while (map.size() > k) {
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}
