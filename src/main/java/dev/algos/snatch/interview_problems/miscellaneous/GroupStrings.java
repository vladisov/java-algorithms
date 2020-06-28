package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * <p>
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 * <p>
 * Example:
 * <p>
 * Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Output:
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */
public class GroupStrings {

    /**
     * Time O(N*L)
     * Space O(N)
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
//            String shifted = shiftToStart(s);
            String shifted = getKey(s);
            map.putIfAbsent(shifted, new ArrayList<>());
            map.get(shifted).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        char[] chars = s.toCharArray();
        StringBuilder key = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            int diff = chars[i] - chars[i - 1];
            key.append(diff < 0 ? diff + 26 : diff);
            key.append(',');
        }
        return key.toString();
    }

    private String shiftToStart(String s) {
        char c = s.charAt(0);
        if (c == 'a') return s;
        StringBuilder sb = new StringBuilder();
        int diff = c - 'a';
        for (char ch : s.toCharArray()) {
            int toStart = ch - 'a';
            if (diff > toStart) {
                sb.append((char) ('z' - (diff - toStart) + 1));
            } else {
                sb.append((char) (ch - diff));
            }
        }
        return sb.toString();
    }
}
