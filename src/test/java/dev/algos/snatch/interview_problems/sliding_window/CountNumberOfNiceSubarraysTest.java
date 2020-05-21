package dev.algos.snatch.interview_problems.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountNumberOfNiceSubarraysTest {

    @Test
    void test() {
        CountNumberOfNiceSubarrays instance = new CountNumberOfNiceSubarrays();
        assertEquals(2, instance.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        assertEquals(0, instance.numberOfSubarrays(new int[]{2, 4, 6}, 1));
        assertEquals(16, instance.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));

        assertEquals(2, instance.numberOfSubarraysPrefix(new int[]{1, 1, 2, 1, 1}, 3));
        assertEquals(0, instance.numberOfSubarraysPrefix(new int[]{2, 4, 6}, 1));
        assertEquals(16, instance.numberOfSubarraysPrefix(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

}
