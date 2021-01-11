package dev.algos.snatch.interview_problems.miscellaneous

import java.util.HashMap


class EncodeStringShortestLength {

    /*
   2[abbb]c2[abbb]c
   */

    var map: MutableMap<String, String> = HashMap()
    fun encode(s: String): String? {
        if (s.isEmpty()) return ""
        if (s.length <= 4) return s
        if (map.containsKey(s)) return map[s]
        var ret: String = s
        for (k in s.length / 2 until s.length) {
            val pattern = s.substring(k)
            val times = countRepeat(s, pattern)
            if (times * pattern.length != s.length) continue
            val candidate = "${times}+[${encode(pattern)}]"
            if (candidate.length < ret.length) ret = candidate
        }
        for (i in 1 until s.length) {
            val left = encode(s.substring(0, i))
            val right = encode(s.substring(i))
            val candidate = left + right
            if (candidate.length < ret.length) ret = candidate
        }
        map[s] = ret
        return ret
    }

    private fun countRepeat(s: String, pattern: String): Int {
        var s = s
        var times = 0
        while (s.length >= pattern.length) {
            val sub = s.substring(s.length - pattern.length)
            s = if (sub == pattern) {
                times++
                s.substring(0, s.length - pattern.length)
            } else return times
        }
        return times
    }
}
