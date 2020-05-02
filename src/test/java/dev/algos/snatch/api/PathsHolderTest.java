package dev.algos.snatch.api;

import dev.algos.snatch.api.dto.PathItemDto;
import dev.algos.snatch.api.service.FileService;
import dev.algos.snatch.api.service.FileServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class PathsHolderTest {

    FileService fileService;

    @BeforeEach
    void setUp() {
        fileService = new FileServiceImpl("");
        ;
    }

    @Test
    void testPathsGenerated() {
        List<PathItemDto> files = fileService.getFiles("/");
        assertThat(files, hasSize(31));
    }

    @Test
    void testTwoSumRun() {
        String s = fileService.runFile("/two_pointers", "TwoSum", new String[]{"[1, 2, 3, 4, 6]", "6"});
        System.out.println(s);
    }

}
