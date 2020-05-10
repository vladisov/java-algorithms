package dev.algos.snatch.api.service;

import dev.algos.snatch.api.parser.GenericClassParser;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import static dev.algos.snatch.api.util.ArgumentCheck.checkArg;
import static java.lang.String.format;

@Slf4j
@Singleton
public class FileRunnerImpl implements FileRunner {

    private static final String BASE_REFERENCE_PATH = "dev.algos.snatch.interview_problems";
    private final GenericClassParser classParser;

    @Inject
    public FileRunnerImpl(GenericClassParser classParser) {
        this.classParser = classParser;
    }

    @Override
    public String runFile(String path, String fileName, String[] args) {
        String fileReference = BASE_REFERENCE_PATH + path.replaceAll("/", ".") + "." + fileName;
        try {
            Class<?> clazz = Class.forName(fileReference);
            Method[] methods = clazz.getDeclaredMethods();

            Method executable = getPublic(methods); // find first public TODO change
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

    private Method getPublic(Method[] methods) {
        for (var method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                return method;
            }
        }
        throw new RuntimeException("Cannot find public method for execution.");
    }

    @Override
    public String runFunction(String path, String fileName, String functionName, String[] args) {
        //TODO
        throw new UnsupportedOperationException();
    }


    private Object[] buildArgs(Method executable, String[] args) {
        Class<?>[] parameters = executable.getParameterTypes();
        Object[] arguments = new Object[parameters.length];

        checkArg(parameters.length == args.length, "Wrong number of parameters!");

        for (int i = 0; i < args.length; i++) {
            arguments[i] = classParser.parseParam(args[i], parameters[i]);
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
