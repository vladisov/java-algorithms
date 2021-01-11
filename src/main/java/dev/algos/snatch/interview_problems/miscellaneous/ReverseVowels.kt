package dev.algos.snatch.interview_problems.miscellaneous

fun reverseVowels(s: String): String {
    val vowels = mutableSetOf('a', 'e', 'i', 'o', 'u')
    val chars = s.toCharArray()
    var i = 0;
    var j = s.length - 1
    while (i < j) {
        while (i < s.length && !vowels.contains(s[i])) {
            i++
        }
        while (j >= 0 && !vowels.contains(s[j])) {
            j--
        }
        if (i < j && i < s.length && j >= 0) {
            val tmp = chars[i]
            chars[i] = chars[j]
            chars[j] = tmp
            i++
            j--
        }
    }
    return String(chars)
}

fun main() {
    println(reverseVowels("hello"))
}
