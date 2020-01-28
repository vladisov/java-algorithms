package dev.algos.snatch.interview_problems.fast_slow_pointers;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HappyNumberTest {
    private HappyNumber instance = new HappyNumber();

    @Test
    void findSuccess() {
        assertThat(instance.find(23), equalTo(true));
    }

    @Test
    void findWithoutSpaceSuccess() {
        assertThat(instance.findWithoutSpace(23), equalTo(true));
    }

    @Test
    void findNotHappy() {
        assertThat(instance.find(12), equalTo(false));
    }

    @Test
    void findWithoutSpaceNot() {
        assertThat(instance.findWithoutSpace(12), equalTo(false));
    }
}
