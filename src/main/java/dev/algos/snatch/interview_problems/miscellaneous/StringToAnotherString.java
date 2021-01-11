package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/string-transforms-into-another-string
 */
public class StringToAnotherString {

    /**
     * Time O(N)
     * Space O(N)
     */
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        if (str1.length() != str2.length()) return false;
        int n = str1.length();
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(str1.charAt(i), str2.charAt(i)) != str2.charAt(i)) {
                return false;
            }
            map.put(str1.charAt(i), str2.charAt(i));
            set.add(str2.charAt(i));
        }
        return map.size() < 26 || set.size() < 26;
    }
}
