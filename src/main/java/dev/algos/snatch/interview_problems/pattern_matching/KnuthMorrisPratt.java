package dev.algos.snatch.interview_problems.pattern_matching;

public class KnuthMorrisPratt {

    /**
     * Time O(p + s)
     * Space O(p)
     */
    boolean kmp(String s, String p) {
        int[] table = buildTable(p);
        int j = 0, i = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }
        return j == p.length();
    }

    int[] buildTable(String s) {
        // [longest suffix which is prefix]
        // dsgwdsgz
        // dsg
        int[] table = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); ) {
            if (s.charAt(i) == s.charAt(j)) {
                table[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = table[j - 1];
                } else {
                    i++;
                }
            }
        }
        return table;
    }
}
