package dev.algos.snatch.interview_problems.ds_design;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class FileSystemTest {

    @Test
    void test() {
        FileSystem fs = new FileSystem();
        assertThat(fs.ls("/"), hasSize(0));
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d", "hello");
        assertThat(fs.ls("/"), hasSize(1));

    }

}
