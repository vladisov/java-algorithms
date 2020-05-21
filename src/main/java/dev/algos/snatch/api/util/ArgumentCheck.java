package dev.algos.snatch.api.util;

public class ArgumentCheck {

    public static void checkArg(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
