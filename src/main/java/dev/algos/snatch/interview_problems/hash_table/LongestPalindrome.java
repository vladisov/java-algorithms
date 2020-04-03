package dev.algos.snatch.interview_problems.hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindrome {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxOdd = 0, even = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                even += entry.getValue();
            } else {
                if (entry.getValue() >= maxOdd) {
                    if (maxOdd != 0) {
                        even += maxOdd - 1;
                    }
                    maxOdd = entry.getValue();
                } else {
                    even += entry.getValue() - 1;
                }
            }
        }
        return even + maxOdd;
    }

    public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hs.contains(s.charAt(i))) {
                hs.remove(s.charAt(i));
                count++; // kinda count of even
            } else {
                hs.add(s.charAt(i));
            }
        }
        if (!hs.isEmpty()) return count * 2 + 1; //if is not empty then even * 2 + one odd
        return count * 2; //even * 2
    }
}
