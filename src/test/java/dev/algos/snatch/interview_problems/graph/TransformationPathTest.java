package dev.algos.snatch.interview_problems.graph;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TransformationPathTest {

    @Test
    void test() {
        TransformationPath tp = new TransformationPath();
        String transformation = tp.findTransformation(0, 7, Set.of(2, 4, 5));
        assertThat(transformation, equalTo("0 10 11 111"));
    }
}
