package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf);
 */

public class ReadNCharactersRead4 extends Reader4 {

    private char[] buffer = new char[4];
    private int index = 0;
    private int readCount = 0;

    /**
     * @param dest Destination buffer
     * @param n    Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] dest, int n) {
        int destIndex = 0;
        boolean endOfFile = false;
        while (destIndex < n && !endOfFile) {
            index %= 4;
            if (readCount > 0) {
                dest[destIndex++] = buffer[index++];
                readCount--;
            } else {
                readCount = read4(buffer);
                if (readCount == 0) {
                    endOfFile = true;
                }
            }
        }
        return destIndex;
    }
}

abstract class Reader4 {
    int read4(char[] buff) {
        return 0;
        //dummy
    }
}
