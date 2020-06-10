package dev.algos.snatch.interview_problems.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoStitchingTest {

    @Test
    void test() {
        VideoStitching vs = new VideoStitching();
        int result = vs.videoStitchingO1(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
        assertEquals(3, result);
    }
}
