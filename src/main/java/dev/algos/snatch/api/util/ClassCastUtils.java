package dev.algos.snatch.api.util;

public class ClassCastUtils {

    public static Object castParam(String arg, Class<?> parameter) {
        if (parameter.isArray()) {
            //get array type
            return getIntArray(arg);
        }
        return Integer.parseInt(arg);
    }

    public static int[] getIntArray(String arg) {
        String[] split = arg.substring(1, arg.length() - 1).split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i].trim());
        }
        return arr;
    }
}
