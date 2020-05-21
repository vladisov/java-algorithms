package dev.algos.snatch.interview_problems.bidirectional_bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpenLockTest {

    @Test
    void test() {
        OpenLock openLock = new OpenLock();
        assertEquals(-1, openLock.openLockBidirectional(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));
        assertEquals(6, openLock.openLockBidirectional(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
}
