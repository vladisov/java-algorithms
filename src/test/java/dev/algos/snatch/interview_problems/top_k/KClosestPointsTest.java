package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KClosestPointsTest {

    @Test
    void test() {
        KClosestPoints kClosestPoints = new KClosestPoints();
        assertEquals("[[-2, 2]]", Arrays.deepToString(kClosestPoints.kClosestQuickSelect(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
