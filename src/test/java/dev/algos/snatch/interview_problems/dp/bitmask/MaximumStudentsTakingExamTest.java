package dev.algos.snatch.interview_problems.dp.bitmask;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MaximumStudentsTakingExamTest {

    @Test
    void test() {
        var instance = new MaximumStudentsTakingExam();
        char[][] seats = {{'#', '.', '#', '#', '.', '#'},
                {'.', '#', '#', '#', '#', '.'},
                {'#', '.', '#', '#', '.', '#'}};
        assertThat(instance.maxStudents(seats), equalTo(4));
    }
}
