package dev.algos.snatch.interview_problems.miscellaneous


class MirrorReflection {
    fun mirrorReflection(p: Int, q: Int): Int {
        var m = 1
        var n = 1
        while (m * p != n * q) {
            n++
            m = n * q / p
        }
        if (n % 2 == 0 && m % 2 != 0) return 2
        if (n % 2 != 0 && m % 2 != 0) return 1
        if (n % 2 != 0 && m % 2 == 0) return 0
        return -1
    }
}
