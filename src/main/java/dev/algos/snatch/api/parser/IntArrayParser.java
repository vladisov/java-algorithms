package dev.algos.snatch.api.parser;


import dev.algos.snatch.api.exception.ParseException;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class IntArrayParser implements Parser {

    private final int dimensions;

    public IntArrayParser(int dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public Object parse(Class<?> parameter, String arg) {
        switch (dimensions) {
            case 1:
                return parseOneDimensional(parameter, arg);
            case 2:
                return parseTwoDimensional(parameter, arg);
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
        if (arg.length() == 4) return new int[0][0];
        return parseArrays(arg.substring(1, arg.length() - 1));
    }

    private int[][] parseArrays(String str) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : str.toCharArray()) queue.add(c);
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == '[') {
                lists.add(parseSubArray(queue));
            }
        }
        if (lists.isEmpty()) {
            return new int[0][0];
        }
        return toArray(lists);
    }

    private int[][] toArray(List<List<Integer>> lists) {
        int[][] arrays = new int[lists.size()][lists.get(0).size()];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[i][j] = lists.get(i).get(j);
            }
        }
        return arrays;
    }

    private List<Integer> parseSubArray(Queue<Character> queue) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == ']') {
                list.add(num);
                return list;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == ',') {
                list.add(num);
                num = 0;
            }
        }
        throw new ParseException("Can't parse two dimentional array");
    }
}
