package dev.algos.snatch.api.service;

import dev.algos.snatch.api.parser.GenericClassParser;
import dev.algos.snatch.api.parser.ParserProviderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class FileRunnerTest {

    FileRunner fileRunner;

    @BeforeEach
    void setUp() {
        fileRunner = new FileRunnerImpl(new GenericClassParser(new ParserProviderImpl()));
    }

    @Test
    void testTwoSumRun() {
        String res = fileRunner.runFile("/two_pointers", "TwoSum", new String[]{"[1, 2, 3, 4, 6]", "6"});
        assertThat(res, equalTo("[1, 3]"));
    }

    @Test
    void testBackspaceCompareRun() {
        String res = fileRunner.runFile("/two_pointers", "BackspaceCompare", new String[]{"xywrrmp", "xywrrmu#p"});
        assertThat(res, is("true"));
    }

    @Test
    void testDijkstraRun() {
        String res = fileRunner.runFile("/dijkstra", "MinimumFlightsWithKStops", new String[]{"5", "[[0, 1, 5], [1, 2, 5], [0, 3, 2], [3, 1, 2], [1, 4, 1], [4, 2, 1]]", "0", "2", "2"});
        assertThat(res, is("true"));
    }
}
