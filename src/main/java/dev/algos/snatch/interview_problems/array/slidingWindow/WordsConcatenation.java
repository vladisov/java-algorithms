package dev.algos.snatch.interview_problems.array.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a list of words,
 * find all the starting indices of substrings in the given string that are a concatenation of all the given words
 * exactly once without any overlapping of words. It is given that all words are of the same length.
 */
class WordsConcatenation {

    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);

        List<Integer> resultIndices = new ArrayList<>();
        int wordsCount = words.length, wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordsCount * wordLength; i++) {
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String word = str.substring(nextWordIndex, nextWordIndex + wordLength);
                if (!wordFrequencyMap.containsKey(word)) // break if we don't need this word
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1); // add the word to the 'wordsSeen' map

                if (wordsSeen.get(word) > wordFrequencyMap.getOrDefault(word, 0))
                    break;

                if (j + 1 == wordsCount) // store index if we have found all the words
                    resultIndices.add(i);
            }
        }

        return resultIndices;
    }
}
