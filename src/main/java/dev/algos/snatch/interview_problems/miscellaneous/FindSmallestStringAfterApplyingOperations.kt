package dev.algos.snatch.interview_problems.miscellaneous

fun findLexSmallestString(s: String, a: Int, b: Int): String {
    return helper(s, a, b, mutableSetOf())
}


fun helper(s: String, a: Int, b: Int, visited: MutableSet<String>): String {
    if (visited.contains(s)) {
        return s
    }
    visited.add(s)
    val added = helper(add(s, a), a, b, visited);
    val rotated = helper(rotate(s, b), a, b, visited);
    return if (added < rotated) return added else rotated
}

fun add(s: String, value: Int): String {
    val chars = s.toCharArray()
    for (i in chars.indices) {
        if (i % 2 == 1) {
            val num = ((chars[i] - '0') + value) % 10
            chars[i] = (num + '0'.toInt()).toChar()
        }
    }
    return String(chars)
}

fun rotate(s: String, value: Int): String {
    val chars = s.toCharArray()
    var i = value
    do {
        val prev = if (i - value < 0) s.length + i - value else i - value
        chars[i] = s[prev]
        i = (i + 1) % s.length
    } while (i != value)
    return String(chars)
}

fun main() {
    print(findLexSmallestString("5525", 9, 2))
}
