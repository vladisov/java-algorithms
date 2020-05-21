package dev.algos.snatch.interview_problems.reservoir_sampling;

import java.util.Random;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

public class GenerateMines {

    public void generateBombs(int[][] grid) {
        int n = grid.length * grid[0].length;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffle(arr);
        int k = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int index = arr[k++];
                int row = index / grid.length;
                int col = index % grid[i].length;
                grid[row][col] = 1;
            }
        }
    }

    private void shuffle(int[] arr) {
        var random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = i + random.nextInt(arr.length - i);
            //or Math.random() * (arr.length - i) + i
            //or int i = random.nextInt(i + 1);
            swap(arr, r, i);
        }
    }
}
