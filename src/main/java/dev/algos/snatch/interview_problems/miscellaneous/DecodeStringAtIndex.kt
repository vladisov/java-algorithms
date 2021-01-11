package dev.algos.snatch.interview_problems.miscellaneous


/**
 * Time O(N)
 * Space O(1)
 */
fun decodeAtIndex(s: String, _k: Int): String {
    var size = 0L
    var k = _k.toLong()
    for (c in s) {
        if (Character.isDigit(c)) {
            size *= (c - '0')
        } else {
            size++
        }
    }
    for (i in s.length - 1 downTo 0) {
        k %= size
        if (k == 0L && Character.isLetter(s[i])) {
            return s[i].toString()
        }
        if (Character.isDigit(s[i])) {
            size /= (s[i] - '0') // we can divide size by digit
        } else {
            size--
        }
    }
    return ""
}

fun main() {
    println(decodeAtIndex("ab23456789999999999999", 1000000000))
    println(decodeAtIndex("a2345678999999999999999", 1000000000))
    println(decodeAtIndex("leet2code3", 10))
}
