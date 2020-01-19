package dev.algos.snatch.interview_problems.gss.two_pointers;

class RemoveDuplicates {

    int remove(int[] arr) {
        int result = arr.length;
        int pointer = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[pointer] == arr[i]) {
                result--;
            }
            if (arr[pointer] != arr[i]) {
                pointer = i;
            }
        }
        return result;
    }
}
