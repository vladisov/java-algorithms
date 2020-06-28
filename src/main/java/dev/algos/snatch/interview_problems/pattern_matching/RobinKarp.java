package dev.algos.snatch.interview_problems.pattern_matching;

import java.util.HashSet;

public class RobinKarp {

    private final long q = (1 << 31) - 1;

    /**
     * Time O(N + M) in worst case O(N^2) depends on hash function
     * Space O(1)
     */
    boolean robinKarp(String s, String p, int alphabet) {
        long pHash = 0, sHash = 0;
        for (int i = 0; i < p.length(); i++) {
            pHash += p.charAt(i) * Math.pow(alphabet, i) % q;
            sHash += s.charAt(i) * Math.pow(alphabet, i) % q;
        }
        int m = p.length() - 1;
        for (int i = p.length(); i <= s.length(); i++) {
            if (pHash == sHash && checkEquals(s, p, i - m - 1)) {
                return true;
            }
            if (i < s.length()) {
                sHash = recalculateHash(sHash, s, i, i - m - 1, alphabet, m);
            }
        }
        return false;
    }

    private long recalculateHash(long oldHash, String s, int newIndex, int oldIndex, int alphabet, int m) {
        long newHash = (oldHash - s.charAt(oldIndex)) / alphabet;
        return (long) (newHash + (s.charAt(newIndex) * Math.pow(alphabet, m)) % q);
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

    /*
    Rabin-Karp with polynomial rolling hash.
    Search m substring of given length
    that occurs at least 2 times.
    Return start position if the substring exits and -1 otherwise.
    */
    public int search(int L, int m, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; i++) {
            h = (h * m + nums[i]) % modulus;
        }

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet<>();
        seen.add(h);
        // const value to be used often : m**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * m) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * m - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }
}
