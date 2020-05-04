package dev.algos.snatch.api.service;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

import static dev.algos.snatch.api.util.ArgumentCheck.checkArg;
import static dev.algos.snatch.api.util.ClassCastUtils.castParam;
import static java.lang.String.format;

@Slf4j
@Singleton
public class FileRunnerImpl implements FileRunner {

    private static String BASE_REFERENCE_PATH = "dev.algos.snatch.interview_problems";

    @Override
    public String runFile(String path, String fileName, String[] args) {
        String fileReference = BASE_REFERENCE_PATH + path.replaceAll("/", ".") + "." + fileName;
        try {
            Class<?> clazz = Class.forName(fileReference);
            Method[] methods = clazz.getDeclaredMethods();
            // we assume we have only one public method, otherwise skip
            checkArg(methods.length == 1, "Cannot find single public method for execution.");

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
