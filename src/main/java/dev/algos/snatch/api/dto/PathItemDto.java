package dev.algos.snatch.api.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class PathItemDto {
    @NonNull
    protected String path;
    protected boolean isDirectory;

    public PathItemDto(@NonNull String path, boolean isDirectory) {
        this.path = path;
        this.isDirectory = isDirectory;
    }
}
