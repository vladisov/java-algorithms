package dev.algos.snatch.api.service;

import com.google.inject.ImplementedBy;
import dev.algos.snatch.api.dto.PathItemDto;

import java.util.List;

@ImplementedBy(FileStorageImpl.class)
public interface FileStorage {

    List<PathItemDto> getFiles(String path);
}
