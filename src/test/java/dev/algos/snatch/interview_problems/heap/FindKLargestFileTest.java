package dev.algos.snatch.interview_problems.heap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FindKLargestFileTest {

    @Test
    @Disabled
    void test() {
        FindKLargestFile instance = new FindKLargestFile();
        File result = instance.findKLargestFile("src/main/java/dev/algos/snatch/interview_problems", 3);
        assertThat(result.getPath(), equalTo("src/main/java/dev/algos/snatch/interview_problems/two_heaps/IPO.java"));
    }
}
