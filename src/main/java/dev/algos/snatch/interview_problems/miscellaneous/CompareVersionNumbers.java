package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.Comparator;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Example 4:
 * <p>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * Example 5:
 * <p>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 */
public class CompareVersionNumbers {

    /**
     * Time O(max(v1,v2))
     * Space O(1)
     */
    public int compareVersion(String version1, String version2) {
        Comparator<String> comparator = (a, b) -> {
            String[] s1 = a.split("\\.");
            String[] s2 = b.split("\\.");
            for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
                String v1 = i >= s1.length ? "0" : removeLeadingZeros(s1[i]);
                String v2 = i >= s2.length ? "0" : removeLeadingZeros(s2[i]);
                int c = compare(v1, v2);
                if (c != 0) return c;
            }
            return 0;
        };
        return comparator.compare(version1, version2);
    }

    private int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return Integer.compare(s1.length(), s2.length());
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            }
        }
        return 0;
    }

    private String removeLeadingZeros(String s) {
        if (s.isEmpty()) return "0";
        int i = 0;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            }
        }
        s = s.substring(i);
        return s.isEmpty() ? "0" : s;
    }
}
