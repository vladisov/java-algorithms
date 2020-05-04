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

    public boolean compare(String S, String T) {
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

    boolean compare1(String s, String t) {
        int sp = s.length() - 1;
        int tp = t.length() - 1;
        while (sp >= 0 || tp >= 0) {
            int schi = getCharIndex(s, sp);
            int tchi = getCharIndex(t, tp);

            if (schi < 0 && tchi < 0) {
                return true;
            }
            if (schi < 0 || tchi < 0) {
                //reached end of one string
                return false;
            }
            if (s.charAt(schi) != t.charAt(tchi)) {
                return false;
            }
            sp = schi - 1;
            tp = tchi - 1;
        }
        return true;
    }

    private int getCharIndex(String s, int index) {
        int countHashSign = 0;
        while (index >= 0) {
            if (s.charAt(index) == '#') {
                countHashSign++;
            } else if (countHashSign > 0) {
                countHashSign--;
            } else {
                break;
            }
            index--;
        }
        return index;
    }
}
