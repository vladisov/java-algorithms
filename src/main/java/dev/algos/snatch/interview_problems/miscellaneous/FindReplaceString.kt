package dev.algos.snatch.interview_problems.miscellaneous

/**
 * Time O(SN)
 * Space O(S)
 */
fun findReplaceString(s: String, indexes: IntArray, sources: Array<String>, targets: Array<String>): String {
    val map = mutableMapOf<Int, Replacement>()
    for (i in indexes.indices) {
        val source = sources[i]
        val target = targets[i]
        val index = indexes[i]
        if (matches(s, source, index)) {
            map[index] = Replacement(source.length, target)
        }
    }
    return buildResult(s, map)
}

fun matches(s: String, source: String, index: Int): Boolean {
    var i = index
    for (j in source.indices) {
        if (i == s.length || s[i++] != source[j]) return false
    }
    return true
}


fun buildResult(s: String, map: MutableMap<Int, Replacement>): String {
    val sb = StringBuilder()
    var i = 0
    while (i < s.length) {
        if (map.containsKey(i)) {
            val replacement = map[i]!!
            sb.append(replacement.sub)
            i += replacement.len
        } else {
            sb.append(s[i++])
        }
    }
    return sb.toString()
}

class Replacement(val len: Int, val sub: String)
