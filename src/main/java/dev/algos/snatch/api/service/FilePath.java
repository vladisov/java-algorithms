package dev.algos.snatch.api.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.nio.file.Path;

@Data
@AllArgsConstructor
public class FilePath {
    private String relativePath;
    private Path absolutePath;
}
