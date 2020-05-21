package dev.algos.snatch.api.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class FileDto extends PathItemDto {
    @NonNull
    private String content;

    public FileDto(String path, boolean isDirectory, String content) {
        super(path, isDirectory);
        this.content = content;
    }
}
