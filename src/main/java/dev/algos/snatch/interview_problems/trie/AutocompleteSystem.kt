package dev.algos.snatch.interview_problems.trie

import java.util.PriorityQueue

class AutocompleteSystem(sentences: Array<String>, times: IntArray) {

    val root: TrieNode
    var curr: TrieNode
    var currSentence: String = ""

    init {
        root = TrieNode()
        curr = root
        for ((i, sentence) in sentences.withIndex()) {
            addWord(sentence, times[i])
        }
    }

    /**
     * Time O(N * L)
     */
    private fun addWord(sentence: String, times: Int) {
        for (i in sentence.indices) {
            val index = getIndex(sentence[i])
            if (curr.children[index] == null) {
                curr.children[index] = TrieNode()
                curr.children[index]!!.parent = curr
            }
            curr = curr.children[index]!!
            curr.map[sentence] = curr.map.getOrDefault(sentence, 0) + times
        }
        curr.endSentence = true
        curr = root
    }

    private fun getIndex(c: Char) = if (c == ' ') 26 else c - 'a'

    /**
     * Time O(Nlog3)
     */
    fun input(c: Char): List<String> {
        if (c == '#') {
            propagateCount(currSentence)
            currSentence = ""
            curr = root
            return arrayListOf()
        }
        val index = getIndex(c)
        if (curr.children[index] == null) {
            curr.children[index] = TrieNode()
            curr.children[index]!!.parent = curr
        }
        curr = curr.children[index]!!
        currSentence += c
        return getTop3(curr)
    }

    private fun propagateCount(currSentence: String) {
        while (true) {
            curr.map[currSentence] = curr.map.getOrDefault(currSentence, 0) + 1
            if (curr.parent == null) {
                break
            } else {
                curr = curr.parent!!
            }
        }
    }

    private fun getTop3(curr: TrieNode): List<String> {
        val queue = PriorityQueue(compareBy<Map.Entry<String, Int>> { it.value }.thenByDescending { it.key })
        for (entry in curr.map.entries) {
            queue.add(entry)
            if (queue.size > 3) {
                queue.poll()
            }
        }
        val res = mutableListOf<String>()
        while (!queue.isEmpty()) res.add(queue.poll().key)
        return res.reversed()
    }

    class TrieNode {
        val children: Array<TrieNode?> = Array(27) { null }
        var endSentence: Boolean = false
        val map = mutableMapOf<String, Int>()
        var parent: TrieNode? = null
    }
}
