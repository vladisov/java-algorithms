package dev.algos.snatch.interview_problems.miscellaneous;

public class ValidPalindrome2 {

    //TODo
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }

        }
        return true;
    }
}
