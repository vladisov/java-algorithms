package dev.algos.snatch.interview_problems.gss.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    private RemoveDuplicates solution = new RemoveDuplicates();


    @Test
    void removeDuplicates() {
        assertEquals(4, solution.remove(new int[]{2, 3, 3, 3, 6, 9, 9}));
        assertEquals(2, solution.remove(new int[]{2, 2, 2, 11}));
    }

}
