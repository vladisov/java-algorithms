package dev.algos.snatch.interview_problems.pattern_matching

class KnuthMorrisPrattKT {

    fun kmp(s: String, p: String): Boolean {
        val table = buildTable(p)
        var i = 0;
        var j = 0
        while (i < s.length && j < p.length) {
            if (s[i] == p[j]) {
                i++
                j++
            } else {
                if (j != 0) {
                    j = table[j - 1]
                } else {
                    i++
                }
            }

        }
        return j == p.length
    }

    /*
       find longest suffix which is prefix
       dsgbvcvdsgbw
        dsgw
       00000001230
    */
    fun buildTable(s: String): IntArray {
        val table = IntArray(s.length)
        var i = 0;
        var j = 1
        while (j < s.length) {
            if (s[i] == s[j]) {
                table[j] = i + 1
                j++
                i++
            } else {
                if (i != 0) {
                    i = table[i - 1] // look back
                } else {
                    j++
                }
            }
        }
        return table
    }
}
