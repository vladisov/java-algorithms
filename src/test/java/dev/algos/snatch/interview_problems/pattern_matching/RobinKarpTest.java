package dev.algos.snatch.interview_problems.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RobinKarpTest {

    @Test
    void test() {
        RobinKarp rk = new RobinKarp();
        assertTrue(rk.robinKarp("adsgwadsxdsgwadsgz", "dsgwadsgz", 26));
        assertTrue(rk.robinKarp("aabaaabaaac", "aabaaac", 26));
    }
}
