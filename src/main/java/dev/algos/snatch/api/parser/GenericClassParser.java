package dev.algos.snatch.api.parser;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ClassUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class GenericClassParser {

    private final ParserProvider parserProvider;

    @Inject
    public GenericClassParser(ParserProvider parserProvider) {
        this.parserProvider = parserProvider;
    }

    public Object parseParam(String arg, Class<?> parameter) {
        Parser parser = parserProvider.provide(parameter);
        return parser.parse(parameter, arg);
    }

    private Object parseArray(Class<?> parameter, String arg) {
        String typeName = parameter.getTypeName();
        try {
            Class<?> aClass = ClassUtils.getClass(typeName);
            int dims = aClass.getName().lastIndexOf("[") + 1;
            if (dims == 1) {
                return getSingleDimIntArray(arg);
            }
            return getTwoDimeIntArray(arg);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Incorrect type provided");
        }
    }

    private int[] getSingleDimIntArray(String arg) {
        String[] split = arg.substring(1, arg.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i].trim());
        }
        return arr;
    }

    private int[] getTwoDimeIntArray(String arg) {
        String[] split = arg.substring(1, arg.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i].trim());
        }
        return arr;
    }
}
