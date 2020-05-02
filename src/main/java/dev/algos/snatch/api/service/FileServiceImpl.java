package dev.algos.snatch.api.service;

import dev.algos.snatch.api.dto.FileDto;
import dev.algos.snatch.api.dto.PathItemDto;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import static dev.algos.snatch.api.util.ArgumentCheck.checkArg;
import static dev.algos.snatch.api.util.ClassCastUtils.castParam;
import static java.lang.String.format;

@Slf4j
public class FileServiceImpl implements FileService {

    private static String PROBLEMS_PATH = "/src/main/java/dev/algos/snatch/interview_problems";
    private static String BASE_REFERENCE_PATH = "dev.algos.snatch.interview_problems";

    private ConcurrentMap<String, List<Path>> paths;

    public FileServiceImpl(String root) {
        this.paths = new ConcurrentHashMap<>();
        var absolutePath = Paths.get(root)
                .toAbsolutePath()
                .toString() + PROBLEMS_PATH;
        collectFiles(Paths.get(absolutePath), paths, absolutePath);
    }

    private void collectFiles(Path rootPath, Map<String, List<Path>> paths, String absolutePath) {
        Queue<Path> queue = new LinkedList<>();
        queue.add(rootPath);
        while (!queue.isEmpty()) {
            Path path = queue.poll();
            try {
                List<Path> filePaths = Files.list(path).collect(Collectors.toList());
                String pathString = path.toString();
                if (pathString.length() != absolutePath.length()) {
                    pathString = pathString.substring(absolutePath.length());
                } else {
                    pathString = "/";
                }
                paths.put(pathString, filePaths);
                queue.addAll(filePaths);
            } catch (IOException ignored) {
            }
        }
    }


    @Override
    public List<PathItemDto> getFiles(@NonNull String path) {
        checkArg(paths.containsKey(path), "No path found for path " + path);

        var paths = this.paths.get(path);
        var dtos = new ArrayList<PathItemDto>();
        paths.forEach(filePath -> {
            File file = filePath.toFile();
            if (file.isDirectory()) {
                var pathItemDto = new PathItemDto(filePath.toString(), true);
                dtos.add(pathItemDto);
            } else {
                try {
                    var content = FileUtils.readFileToString(file, "UTF-8");
                    var fileDto = new FileDto(filePath.toString(), false, content);
                    dtos.add(fileDto);
                } catch (IOException ignored) {
                }
            }
        });
        return dtos;
    }

    @Override
    public String runFile(String path, String fileName, String[] args) {
        String fileReference = BASE_REFERENCE_PATH + path.replaceAll("/", ".") + "." + fileName;
        try {
            Class<?> clazz = Class.forName(fileReference);
            Method[] methods = clazz.getDeclaredMethods();

            // we assume we have only one public method, otherwise skip
            checkArg(methods.length > 1, "Cannot find single public method for execution.");

            Method executable = methods[0];
            Object[] arguments = buildArgs(executable, args);
            Constructor<?>[] constructors = clazz.getConstructors();
            checkArg(constructors.length > 0, format("Cant find public constructor for class %s", clazz.getName()));

            Object instance = clazz.getConstructors()[0].newInstance();
            Object result = executable.invoke(instance, arguments);
            return objectToString(result);
        } catch (Exception e) {
            log.error("Cannot run the file", e);
        }
        throw new IllegalArgumentException("Couldn't find executable file with provided parameters.");
    }

    private Object[] buildArgs(Method executable, String[] args) {
        Class<?>[] parameters = executable.getParameterTypes();
        Object[] arguments = new Object[parameters.length];

        checkArg(parameters.length == args.length, "Wrong number of parameters!");

        for (int i = 0; i < args.length; i++) {
            arguments[i] = castParam(args[i], parameters[i]);
        }
        return arguments;
    }

    private String objectToString(Object o) {
        if (o.getClass().isArray()) {
            var typeName = o.getClass().getTypeName();
            switch (typeName) {
                case "int[]":
                    return Arrays.toString((int[]) o);
                case "long[]":
                    return Arrays.toString((long[]) o);
                default:
                    return Arrays.deepToString((Object[]) o);
            }
        }
        return o.toString();
    }
}
