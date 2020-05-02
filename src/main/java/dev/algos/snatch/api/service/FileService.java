package dev.algos.snatch.api.service;

import dev.algos.snatch.api.dto.PathItemDto;

import java.util.List;

public interface FileService {

    List<PathItemDto> getFiles(String path);

    String runFile(String path, String fileName, String[] args);
}
