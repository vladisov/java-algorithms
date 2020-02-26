package dev.algos.snatch.interview_problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem statement
 * Given a set of hotels and its guests reviews, sort the hotels based on a list of words specified by a user.
 * The criteria to sort the hotels should be how many times the words specified by the user is mentioned in the hotel reviews.
 * <p>
 * Input
 * The first line contains a space-separated set of words which we want to find mentions in the hotel reviews.
 * <p>
 * The second line contains one integer M, which is the number of reviews.
 * <p>
 * This is followed by M+M lines, which alternates an hotel ID and a review belonging to that hotel.
 * <p>
 * Output
 * A list of hotel IDs sorted, in descending order, by how many mentions they have of the words specified in the input.
 * <p>
 * Notes
 * – The words to be find will always be singe words line ‘breakfast’ or ‘noise’. Never double words like ‘swimming pool’.
 * – Hotel ud is a 4-byte integer.
 * – Words match should be case-insensitive.
 * – Dots and commas should be ignored.
 * – If a word appears in a review twice, it should count twice.
 * – If two hotels have the same number of mentions, they should be sorted in the output based on their ID, smallest ID first.
 * – In case one or more test cases time out, consider revisiting the runtime complexity of your algorithms.
 * <p>
 * Sample input
 * <p>
 * breakfast beach citycenter location metro view staff price
 * 5
 * 1
 * This hotel has a nice view of the citycenter. The location is perfect.
 * 2
 * The breakfast is ok. Regarding the location, it is quite far from citycenter but price is cheap so it is worth.
 * 1
 * Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.
 * 1
 * They said I could't take my dog and there were other guests with dogs! That is not fair!
 * 2
 * Very friendly staff and goof cost-benefit ratio. Its location is a bit far from citycenter.
 * Sample output
 * <p>
 * 2 1
 */
public class SortHotel {

    List<Integer> sortHotels(String info) {
        String[] lines = info.split("\n");
        String wordsLine = lines[0];
        String[] words = wordsLine.split("\\s+");
        Set<String> wordsSet = new HashSet<>();
        for (String word : words) {
            wordsSet.add(word.toLowerCase());
        }
        List<Review> reviews = new ArrayList<>();
        for (int i = 2; i < lines.length; i += 2) {
            int id = Integer.parseInt(lines[i]);
            String text = lines[i + 1];
            Review review = new Review(id, text);
            reviews.add(review);
        }

        Map<Integer, Integer> hotelFreq = new HashMap<>();
        for (Review review : reviews) {
            String[] reviewWords = review.text.split("\\s+|(?=[,.])");
            for (String word : reviewWords) {
                word = word.toLowerCase();
                if (wordsSet.contains(word)) {
                    hotelFreq.put(review.hotelId, hotelFreq.getOrDefault(review.hotelId, 0) + 1);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(hotelFreq.entrySet());
        sorted.sort((a, b) -> b.getValue() - a.getValue());
        return sorted.stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    static class Review {
        int hotelId;
        String text;

        public Review(int hotelId, String text) {
            this.hotelId = hotelId;
            this.text = text;
        }
    }
}
