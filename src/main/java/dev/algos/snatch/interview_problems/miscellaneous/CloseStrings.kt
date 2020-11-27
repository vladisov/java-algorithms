package dev.algos.snatch.interview_problems.miscellaneous

import java.util.Arrays

/**
Two strings are considered close if you can attain one from the other using the following operations:
Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

 */
class CloseStrings {

    //word1 = "cabbba", word2 = "abbccc"
    fun closeStrings(a: String, b: String): Boolean {
        if (a.length != b.length) return false
        val mapA = IntArray(26)
        val mapB = IntArray(26)
        for (i in a.indices) mapA[a[i] - 'a']++
        for (i in b.indices) mapB[b[i] - 'a']++
        for (i in 0..25) {
            val aCount = mapA[i]
            val bCount = mapB[i]
            if ((aCount > 0 && bCount == 0) || (bCount > 0 && aCount == 0)) return false
        }
        Arrays.sort(mapA)
        Arrays.sort(mapB)
        for (i in 0..25) {
            if (mapA[i] != mapB[i]) return false
        }
        return true
    }

}
