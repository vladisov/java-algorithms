package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 */
public class RestoreIpAddress {

    /**
     * Time complexity : as discussed above, there is not more than 27 combinations to check.
     * Space complexity : constant space to keep the solutions, not more than 19 valid IP addresses or  n / ? ??
     */
    public List<String> restoreIpAddresses(String s) {
        if (!canBeValid(0, s, 3)) return List.of();
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), 3, result);
        return result;
    }

    void backtrack(String s, int start, StringBuilder sb, int dots, List<String> result) {
        if (dots == 0) {
            if (s.length() - start <= 3) {
                String sub = s.substring(start);
                if (isValidSub(s.substring(start))) {
                    result.add(sb.toString() + sub);
                }
            }
        } else {
            for (int i = start + 1; i <= Math.min(s.length(), start + 3); i++) {
                if (!canBeValid(i, s, dots - 1)) continue;
                String first = s.substring(start, i);
                if (!isValidSub(first)) break;
                sb.append(first).append(".");
                backtrack(s, i, sb, dots - 1, result);
                sb.delete(sb.length() - first.length() - 1, sb.length());
            }
        }
    }

    boolean isValidSub(String s) {
        if (s.isEmpty() || (s.length() > 1 && s.charAt(0) == '0')) return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }

    boolean canBeValid(int start, String ip, int dots) {
        int len = ip.length() - start;
        int parts = dots + 1;
        return len / parts < 3 || (len / parts == 3 && len % parts == 0);
    }
}
