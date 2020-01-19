package dev.algos.snatch.interview_problems.gss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-08
 */
class ProductOfArrayExceptItselfTest {

    private ProductOfArrayExceptItself instance;

    @BeforeEach
    void setUp() {
        instance = new ProductOfArrayExceptItself();
    }

    @Test
    void productHappyPath() {
        int[] result = instance.productExceptSelf(new int[]{1, 2, 3, 4});
        assertThat(result, equalTo(new int[]{24, 12, 8, 6}));
    }

    @Test
    void productHappyPath2() {
        int[] result = instance.productExceptSelf(new int[]{2, 3, 4, 5});
        assertThat(result, equalTo(new int[]{60, 40, 30, 24}));
    }

    @Test
    void productEmptyArray() {
        int[] result = instance.productExceptSelf(new int[]{});
        assertThat(result, equalTo(new int[]{}));
    }

    @Test
    void productSingleElement() {
        int[] result = instance.productExceptSelf(new int[]{1});
        assertThat(result, equalTo(new int[]{1}));
    }
}
