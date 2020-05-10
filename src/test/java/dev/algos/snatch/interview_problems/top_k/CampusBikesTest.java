package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampusBikesTest {

    @Test
    void test() {
        CampusBikes campusBikes = new CampusBikes();
        int[] result = campusBikes.assignBikesBucketSort(new int[][]{{0, 0}, {1, 1}, {2, 0}}, new int[][]{{1, 0}, {2, 2}, {2, 1}});
        assertEquals("[0, 2, 1]", Arrays.toString(result));
    }
}
