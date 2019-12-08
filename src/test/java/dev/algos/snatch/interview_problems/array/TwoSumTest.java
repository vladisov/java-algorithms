package dev.algos.snatch.interview_problems.array;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;


/**
 * @author vladov 2019-12-01
 */
class TwoSumTest {

    private TwoSum instance;

    @BeforeEach
    void setUp() {
        instance = new TwoSum();
    }

    @Test
    void twoSumHappyPath() {
        Integer[] result = ArrayUtils.toObject(instance.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertThat(result, arrayContainingInAnyOrder(0, 1));
    }

    @Test
    void twoSumNotFound() {
        int[] primResult = instance.twoSum(new int[]{2, 7, 11, 15}, -1);
        Integer[] result = ArrayUtils.toObject(primResult);
        assertThat(result, arrayContaining(-1, -1));
    }

    @Test
    void twoSumEmptyArr() {
        int[] primResult = instance.twoSum(new int[]{}, -1);
        Integer[] result = ArrayUtils.toObject(primResult);
        assertThat(result, arrayContaining(-1, -1));
    }

    @Test
    void twoSumNegative() {
        int[] primResult = instance.twoSum(new int[]{-1, 0, 1, 5}, 0);
        Integer[] result = ArrayUtils.toObject(primResult);
        assertThat(result, arrayContaining(0, 2));
    }
}