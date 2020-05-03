package dev.algos.snatch.api;

import dev.algos.snatch.api.dto.PathItemDto;
import dev.algos.snatch.api.service.FileStorage;
import dev.algos.snatch.api.service.FileStorageImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

class FileStorageTest {

    FileStorage fileStorage;
    String absolutePath;

    @BeforeEach
    void setUp() {
        fileStorage = new FileStorageImpl();
        absolutePath = Paths.get("")
                .toAbsolutePath()
                .toString() + "/src/main/java/dev/algos/snatch/interview_problems";
    }

    @Test
    void testPathsGenerated() {
        List<PathItemDto> files = fileStorage.getFiles("/");
        assertThat(files, hasItem(new PathItemDto(absolutePath + "/dijkstra", true)));
        assertThat(files, hasItem(new PathItemDto(absolutePath + "/binary_search", true)));
        assertThat(files, hasItem(new PathItemDto(absolutePath + "/array", true)));
        assertThat(files, hasItem(new PathItemDto(absolutePath + "/graph", true)));
        assertThat(files, hasItem(new PathItemDto(absolutePath + "/matrix", true)));
        assertThat(files, hasSize(31));
    }
}
