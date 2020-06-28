package dev.algos.snatch.interview_problems.pattern_matching;

import java.util.HashSet;
import java.util.Set;

public class LongestDuplicatedSubstring {

    public String longestDupSubstring(String s) {
        int left = 1, right = s.length();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (robinKarp(s, mid, 26) != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        int start = robinKarp(s, left - 1, 26);
        return s.substring(start, start + left - 1);
    }

    int robinKarp(String s, int len, int alphabet) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash += s.charAt(i) * Math.pow(alphabet, i);
        }
        Set<Long> seen = new HashSet<>();
        int m = len - 1;
        for (int i = len; i <= s.length(); i++) {
            if (seen.contains(hash)) {
                return i - m - 1;
            }
            seen.add(hash);
            if (i < s.length()) {
                hash = recalculateHash(hash, s, i, i - m - 1, alphabet, m);
            }
        }
        return -1;
    }

    private long recalculateHash(long oldHash, String s, int newIndex, int oldIndex, int alphabet, int m) {
        long newHash = (oldHash - s.charAt(oldIndex)) / alphabet;
        return (long) (newHash + (s.charAt(newIndex) * Math.pow(alphabet, m)));
    }

    private boolean checkEquals(String s, String p, int start) {
        int pStart = 0;
        while (start < s.length() && pStart < p.length()) {
            if (s.charAt(start++) != p.charAt(pStart++)) {
                return false;
            }
        }
        return true;
    }
}
