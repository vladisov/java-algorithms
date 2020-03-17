package dev.algos.snatch.interview_problems.xor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ComplementOfBase10Test {

    @Test
    void test() {
        ComplementOfBase10 instance = new ComplementOfBase10();
        assertThat(instance.bitwiseComplement(8), equalTo(7));
    }
}
