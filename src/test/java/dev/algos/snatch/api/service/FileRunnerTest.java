package dev.algos.snatch.api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class FileRunnerTest {

    FileRunner fileRunner;

    @BeforeEach
    void setUp() {
        fileRunner = new FileRunnerImpl();
    }

    @Test
    void testTwoSumRun() {
        String res = fileRunner.runFile("/two_pointers", "TwoSum", new String[]{"[1, 2, 3, 4, 6]", "6"});
        assertThat(res, equalTo("[1, 3]"));
    }

    @Test
    void testBackspaceCompareRun() {
        String res = fileRunner.runFile("/two_pointers", "BackspaceCompare", new String[]{"xywrrmp", "xywrrmu#p"});
        assertThat(res, equalTo("true"));
    }
}
