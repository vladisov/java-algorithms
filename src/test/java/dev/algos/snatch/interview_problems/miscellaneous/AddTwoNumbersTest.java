package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AddTwoNumbersTest {

    @Test
    void testBaseCase() {
        AddTwoNumbers instance = new AddTwoNumbers();
        assertThat(instance.add(5, 7), equalTo(12));
    }

}
