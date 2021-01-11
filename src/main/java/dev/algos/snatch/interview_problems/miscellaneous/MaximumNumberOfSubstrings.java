package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/
 */
public class MaximumNumberOfSubstrings {

    /**
     * Time O(26)
     * Space O(N)
     */
    public List<String> maxNumOfSubstrings(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        int[][] intervals = new int[26][2];
        for (int i = 0; i < 26; i++) {
            var interval = getInterval(s, (char) (i + 'a'), freq);
            intervals[i] = interval;
        }
        List<int[]> substrings = getSubstrings(s, intervals);
        if (substrings.isEmpty()) return List.of();
        substrings.sort((a, b) -> (a[0] - b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.add(substrings.get(0));
        for (int i = 1; i < substrings.size(); i++) {
            boolean add = true;
            var sub = substrings.get(i);
            while (!stack.isEmpty() && stack.peek()[1] >= sub[0]) {
                int prevSize = stack.peek()[1] - stack.peek()[0] + 1;
                int size = sub[1] - sub[0] + 1;
                if (prevSize > size) {
                    stack.pop();
                } else {
                    add = false;
                    break;
                }
            }
            if (add) stack.add(sub);
        }
        List<String> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            var sub = stack.pop();
            ans.add(s.substring(sub[0], sub[1] + 1));
        }
        return ans;
    }

    private List<int[]> getSubstrings(String s, int[][] intervals) {
        List<int[]> substrings = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] != -1) {
                int start = interval[0], end = interval[1];
                boolean expand = true;
                while (expand) {
                    for (int i = start; i <= end; i++) {
                        int index = s.charAt(i) - 'a';
                        if (start > intervals[index][0]) {
                            start = intervals[index][0];
                            break;
                        }
                        if (end < intervals[index][1]) {
                            end = intervals[index][1];
                            break;
                        }
                        if (i == end) {
                            expand = false;
                        }
                    }
                }
                substrings.add(new int[]{start, end});
            }
        }
        return substrings;
    }

    private int[] getInterval(String s, char c, int[] freq) {
        int[] interval = new int[]{-1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                if (count == 0) {
                    interval[0] = i;
                }
                count++;
                if (count == freq[c - 'a']) {
                    interval[1] = i;
                    break;
                }
            }
        }
        return interval;
    }
}
