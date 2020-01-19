package dev.algos.snatch.interview_problems.gss;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductOfArrayExceptSelfTest {

    private ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

    @Test
    void productTest() {
        int[] result = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        int[] expected = new int[]{24, 12, 8, 6};
        assertThat(result, is(expected));
    }
}
