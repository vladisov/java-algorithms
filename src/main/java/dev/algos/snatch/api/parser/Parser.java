package dev.algos.snatch.api.parser;

public interface Parser {
    Object parse(Class<?> parameter, String arg);
}
