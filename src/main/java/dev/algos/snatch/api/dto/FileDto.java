package dev.algos.snatch.api.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FileDto extends PathItemDto {
    @NonNull
    private String content;

    public FileDto(String path, boolean isDirectory, String content) {
        super(path, isDirectory);
        this.content = content;
    }
}
