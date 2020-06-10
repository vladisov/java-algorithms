package dev.algos.snatch.interview_problems.sliding_window;

/**
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * Example 1:
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are
 * "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 */
public class NumberOfStringsContainingAllThreeCharacters {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int numberOfSubstrings(String s) {
        int count[] = {0, 0, 0}, res = 0, i = 0, n = s.length();
        for (int j = 0; j < n; ++j) {
            ++count[s.charAt(j) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0)
                --count[s.charAt(i++) - 'a'];
            res += i; // works because we only have a b c, so every time we're here we add
            //i - index how many we can add
        }
        return res;
    }
}
