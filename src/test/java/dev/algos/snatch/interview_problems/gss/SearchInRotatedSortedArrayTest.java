package dev.algos.snatch.interview_problems.gss;

import dev.algos.snatch.interview_problems.binary_search.SearchInRotatedSortedArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vladov 2019-12-10
 */
class SearchInRotatedSortedArrayTest {

    private SearchInRotatedSortedArray instance;

    @BeforeEach
    void setUp() {
        instance = new SearchInRotatedSortedArray();
    }

    @Test
    void searchTargetRight() {
        int result = instance.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
        assertThat(result, equalTo(4));
    }

    @Test
    void searchTargetLeft() {
        int result = instance.search(new int[]{7, 8, 0, 1, 2, 3, 4, 5, 6}, 0);
        assertThat(result, equalTo(2));
    }

    @Test
    void searchTargetMid() {
        int result = instance.search(new int[]{4, 5, 6, 0, 1, 2, 3}, 0);
        assertThat(result, equalTo(3));
    }

    @Test
    void searchSingleValue() {
        int result = instance.search(new int[]{4}, 4);
        assertThat(result, equalTo(0));
    }

    @Test
    void searchNotFound() {
        int result = instance.search(new int[]{5}, 4);
        assertThat(result, equalTo(-1));
    }

    @Test
    void searchTwoValues() {
        int result = instance.search(new int[]{5, 4}, 4);
        assertThat(result, equalTo(1));
    }

    @Test
    void searchEmptyArray() {
        int result = instance.search(new int[]{}, 4);
        assertThat(result, equalTo(-1));
    }
}
