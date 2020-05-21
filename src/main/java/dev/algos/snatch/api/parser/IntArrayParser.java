package dev.algos.snatch.api.parser;

public class IntArrayParser implements Parser {

    private final int dimensions;

    public IntArrayParser(int dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Object parse(Class<?> parameter, String arg) {
        switch (dimensions) {
            case 1:
                parseOneDimensional(parameter, arg);
            case 2:
                parseTwoDimensional(parameter, arg);
        }
        throw new RuntimeException("Array type is not supported yet.");
    }

    private Object parseOneDimensional(Class<?> parameter, String arg) {
        String[] split = arg.substring(1, arg.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i].trim());
        }
        return arr;
    }

    private Object parseTwoDimensional(Class<?> parameter, String arg) {
        String[] split = arg.substring(1, arg.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i].trim());
        }
        return arr;
    }
}
