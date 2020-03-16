package dev.algos.snatch.interview_problems.two_pointers;

public class IncreasingDecreasingString {

    public String sortString(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            sb.append(sort(arr));
        }
        return sb.toString();
    }

    private String sort(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                char c = (char) (i + 'a');
                sb.append(c);
                arr[i]--;
                if (sb.length() > 1 && arr[i] > 0) {
                    break;
                }
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                char c = (char) (i + 'a');
                sb.append(c);
                arr[i]--;
                if (sb.length() > 1 && arr[i] > 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
