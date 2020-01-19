package dev.algos.snatch.interview_problems.two_pointers;

/**
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * <p>
 * Example 1:
 * <p>
 * Input: str1="xy#z", str2="xzz#"
 * Output: true
 * Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
 * Example 2:
 * <p>
 * Input: str1="xy#z", str2="xyz#"
 * Output: false
 * Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
 * Example 3:
 * <p>
 * Input: str1="xp#", str2="xyz##"
 * Output: true
 * Explanation: After applying backspaces the strings become "x" and "x" respectively.
 * In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
 * Example 4:
 * <p>
 * Input: str1="xywrrmp", str2="xywrrmu#p"
 * Output: true
 * Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
 */
public class BackspaceCompare {

    boolean compare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
                if (S.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            char left = i < 0 ? '@' : S.charAt(i);
            while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
                if (T.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char right = j < 0 ? '@' : T.charAt(j);
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }
}
