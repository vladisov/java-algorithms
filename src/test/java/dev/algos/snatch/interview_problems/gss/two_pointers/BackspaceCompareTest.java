package dev.algos.snatch.interview_problems.gss.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackspaceCompareTest {

    private BackspaceCompare solution = new BackspaceCompare();

    @Test
    void compareTrue() {
        assertTrue(solution.compare("xy#z", "xzz#"));
        assertTrue(solution.compare("xp#", "xyz##"));
        assertTrue(solution.compare("xywrrmp", "xywrrmu#p"));
    }

    @Test
    void compareFalse() {
        assertFalse(solution.compare("xy#z", "xyz#"));
    }

}
