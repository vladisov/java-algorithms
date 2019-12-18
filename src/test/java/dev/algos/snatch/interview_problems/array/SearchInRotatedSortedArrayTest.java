package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();

    @Test
    void searchInRotatedSortedArray() {
        assertEquals(4, solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, solution.search(new int[]{4,5,6,7,0,1,2}, 3));
    }
}
