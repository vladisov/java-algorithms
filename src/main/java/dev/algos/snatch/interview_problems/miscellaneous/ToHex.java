package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 */
public class ToHex {

    /**
     * Time O(logb(n))
     * Space O(1)
     */
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        long val = num < 0 ? 0XffffffffL + 1 + num : num, carry;
        var sb = new StringBuilder();
        while (val > 15) {
            carry = val % 16;
            val /= 16;
            sb.append(map[(int) carry]);
        }
        return sb.append(map[(int) val])
                .reverse()
                .toString();
    }
}
