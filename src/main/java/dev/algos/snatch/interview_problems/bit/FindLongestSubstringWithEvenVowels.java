package dev.algos.snatch.interview_problems.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * <p>
 * Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 * <p>
 * Example 1:
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 * Example 2:
 */
public class FindLongestSubstringWithEvenVowels {

    /**
     * Time O(N)
     * Space O(2^4) O(1)
     **/
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int curr = 0, len = 0;// curr - binary map of aeiou  00000
        for (int i = 0; i < s.length(); i++) {
            curr ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1; //to get rid of -1
            if (map.containsKey(curr)) { // classic prefix sum, looking for binary prefix
                len = Math.max(len, i - map.get(curr));
            }
            map.putIfAbsent(curr, i);
        }
        return len;
    }
}
