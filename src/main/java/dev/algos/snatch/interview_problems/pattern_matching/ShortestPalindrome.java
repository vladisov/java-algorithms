package dev.algos.snatch.interview_problems.pattern_matching;

public class ShortestPalindrome {


    /**
     * Time O(N)
     * Space O(N)
     */
    public String shortestPalindrome(String s) {
        String concat = s + "#" + new StringBuilder(s).reverse().toString();
        //finding longest palindromic substring
        int[] table = buildTable(concat);
        String suffix = s.substring(table[table.length - 1]);
        String reversed = new StringBuilder(suffix).reverse().toString();
        return reversed + s;
    }

    private int[] buildTable(String s) {
        int[] table = new int[s.length()];
        int i = 0, index = 1;
        while (index < s.length()) {
            if (s.charAt(i) == s.charAt(index)) {
                table[index] = i + 1;
                index++;
                i++;
            } else {
                if (i != 0) {
                    i = table[i - 1];
                } else {
                    index++;
                }
            }
        }
        return table;
    }
}
