package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditDistanceTest {

    @Test
    void test() {
        var editDistance = new EditDistance();
        assertEquals(2, editDistance.findEditDistance("abdca", "cbda"));
        assertEquals(1, editDistance.findEditDistance("bat", "but"));
        assertEquals(3, editDistance.findEditDistance("passpot", "ppsspqrt"));
        assertEquals(2, editDistance.minDistanceBU("abdca", "cbda"));
        assertEquals(1, editDistance.minDistanceBU("bat", "but"));
        assertEquals(3, editDistance.minDistanceBU("passpot", "ppsspqrt"));
        assertEquals(3, editDistance.minDistanceBU("horse", "ros"));
    }
}
