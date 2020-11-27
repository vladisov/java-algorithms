package dev.algos.snatch.interview_problems.trie

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test

internal class AutocompleteSystemTest {

    @Test
    fun test() {
        val autocompleteSystem = AutocompleteSystem(arrayOf("i love you", "island", "ironman", "i love leetcode"), intArrayOf(5, 3, 2, 2))
        assertThat(autocompleteSystem.input('i'), contains("i love you", "island", "i love leetcode"))
        assertThat(autocompleteSystem.input(' '), contains("i love you", "i love leetcode"))
        assertThat(autocompleteSystem.input('a'), hasSize(0))
        assertThat(autocompleteSystem.input('#'), hasSize(0))
        assertThat(autocompleteSystem.input('i'), contains("i love you", "island", "i love leetcode"))
        assertThat(autocompleteSystem.input(' '), contains("i love you", "i love leetcode", "i a"))
        assertThat(autocompleteSystem.input('a'), contains("i a"))
        assertThat(autocompleteSystem.input('#'), hasSize(0))
    }
}
