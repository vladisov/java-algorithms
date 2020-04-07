package dev.algos.snatch.interview_problems.hash_table;

/**
 * Given a string s and an integer k. You should construct k non-empty palindrome strings using all the characters in s.
 * <p>
 * Return True if you can use all the characters in s to construct k palindrome strings or False otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "annabelle", k = 2
 * Output: true
 * Explanation: You can construct two palindromes using all characters in s.
 * Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
 * Example 2:
 * <p>
 * Input: s = "leetcode", k = 3
 * Output: false
 * Explanation: It is impossible to construct 3 palindromes using all the characters of s.
 * Example 3:
 * <p>
 * Input: s = "true", k = 4
 * Output: true
 * Explanation: The only possible solution is to put each character in a separate string.
 */
public class CanConstructKPalindromicStrings {

    /**
     * Time O(N)
     * Space O(26) = O(1)
     */
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;
        if (s.length() == k) return true;

        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        int odds = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0 && map[i] % 2 == 1) {
                odds++;
            }
        }
        return odds <= k;
    }
}
