package dev.algos.snatch.api.service;

import dev.algos.snatch.api.dto.FileDto;
import dev.algos.snatch.api.dto.PathItemDto;
import dev.algos.snatch.api.exception.PathNotFound;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Slf4j
@Singleton
public class FileStorageImpl implements FileStorage {

    private static final String PROBLEMS_PATH = "/src/main/java/dev/algos/snatch/interview_problems";

    private final String absolutePath;
    private final ConcurrentMap<String, List<FilePath>> paths;

    public FileStorageImpl() {
        this.paths = new ConcurrentHashMap<>();
        this.absolutePath = Paths.get("")
                .toAbsolutePath()
                .toString() + PROBLEMS_PATH;
        collectFiles(Paths.get(absolutePath), paths, absolutePath);
    }

    private void collectFiles(Path rootPath, ConcurrentMap<String, List<FilePath>> paths, String absolutePath) {
        Queue<FilePath> queue = new LinkedList<>();
        queue.add(new FilePath("/", rootPath));
        while (!queue.isEmpty()) {
            FilePath path = queue.poll();
            try {

                List<FilePath> filePaths = Files.list(path.getAbsolutePath())
                        .map(filePath -> new FilePath(buildRelativePath(filePath), filePath))
                        .collect(Collectors.toList());

                paths.put(path.getRelativePath(), filePaths);
                queue.addAll(filePaths);
            } catch (IOException ignored) {
            }
        }
    }

    private String buildRelativePath(Path path) {
        String pathString = path.toString();
        if (pathString.length() != absolutePath.length()) {
            return pathString.substring(absolutePath.length());
        }
        return "/";
    }

    @Override
    public List<PathItemDto> getFiles(@NonNull String path) {
        path = "/" + path;
        if (!paths.containsKey(path)) {
            throw new PathNotFound("No path found for " + path);
        }

        var paths = this.paths.get(path);
        var dtos = new ArrayList<PathItemDto>();
        paths.forEach(filePath -> {
            File file = filePath.getAbsolutePath().toFile();
            if (file.isDirectory()) {
                var pathItemDto = new PathItemDto(filePath.getRelativePath(), true);
                dtos.add(pathItemDto);
            } else {
                try {
                    var content = FileUtils.readFileToString(file, "UTF-8");
                    var fileDto = new FileDto(filePath.getRelativePath(), false, content);
                    dtos.add(fileDto);
                } catch (IOException ignored) {
                }
            }
        });
        return dtos;
    }
}
