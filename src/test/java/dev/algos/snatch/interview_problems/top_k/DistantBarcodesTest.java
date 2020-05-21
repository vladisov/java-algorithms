package dev.algos.snatch.interview_problems.top_k;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DistantBarcodesTest {


    @Test
    void test() {
        DistantBarcodes codes = new DistantBarcodes();
        assertThat(Arrays.toString(codes.rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3})), equalTo("[1, 3, 1, 2, 1, 2, 1, 3]"));
        assertThat(Arrays.toString(codes.rearrangeBarcodesOptimized(new int[]{1, 1, 1, 1, 2, 2, 3, 3})), equalTo("[1, 2, 1, 2, 1, 3, 1, 3]"));
    }
}
