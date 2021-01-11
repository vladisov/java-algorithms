package dev.algos.snatch.interview_problems.miscellaneous

import kotlin.math.max

fun maxProduct(words: Array<String>): Int {
    val map = Array(26) { mutableSetOf<String>() }
    val freqs = Array(words.size) { IntArray(26) }
    for ((index, word) in words.withIndex()) {
        for (i in word.indices) {
            freqs[index][word[i] - 'a']++
            map[word[i] - 'a'].add(word)
        }
    }
    var max = 0
    for (index in words.indices) {
        val candidates = mutableSetOf<String>()
        for (word in words) candidates.add(word)
        for (i in 0 until 26) {
            if (freqs[index][i] != 0) {
                for (candidate in map[i]) {
                    candidates.remove(candidate)
                }
            }
        }
        if (candidates.size > 0) {
            val len = candidates.maxBy { it.length }!!.length
            max = max(len * words[index].length, max)
        }
    }
    return max
}


fun main() {
    println(maxProduct(arrayOf("vfa", "xtlz", "efvep", "qax", "xttqeqhdzda", "dotpkwl", "vzexpeg", "lnwcc", "tz", "oddqwzk", "qpo", "wa", "gahbx", "dxmffnv", "pwcawa", "gp", "bmfomiyep", "pqlbfol", "yvkxl", "mewwmixa", "adbqqe", "ihdeoawnpo", "sreiw", "ohppahwicoq", "wgw", "zrjow", "qwqebael", "rlkrx", "njraonrxx", "cmkdzas", "ctcrryvpyc", "kcsbd", "uvmjcmelngg", "rznp", "hezmqrsdoe", "doxsmfh", "sxbpdfio", "bg", "fwjgmgjez", "pskvtosefsx", "gcj", "xv", "rcoabdx", "zsgag", "uohvz", "dsmffq", "nbbtm", "ercccjym", "iagqmyauqun", "czwexke", "unig", "iyczgxmakc", "qgnjfqai", "qbatxtev", "qpp", "jp", "bg", "ek", "jbele", "oepzeekydf", "xfncmi", "dyr", "htnbkxtaxo", "hvglb", "iao", "sgqw", "vwnmvcjtu", "tc", "ylyn", "wzibe", "ywzemkxnds", "bapdoxed", "fuosanrps", "iqnidqfprif", "ibeweskp", "vdoofj", "ybnwnqtyx", "jbzuipwr", "vjtfp", "ihgunpppa", "hohpqb", "upjtrljrg", "pgh", "av", "cglwgcpac", "tznomaqzd", "kxigufgqhqp", "wt", "iyahn", "vnmjndkd", "dde", "uztuzssitar", "wvd", "svr", "cy", "gtvh", "hefltcdldzj", "itrd", "egszngv", "pxr")))
}
