package dev.algos.snatch.interview_problems.xor;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String addBinaryCarry(String a, String b) {
        StringBuilder sb = new StringBuilder(); //Google immutability or string vs stringbuilder if you don't know why we use this instead of regular string
        int i = a.length() - 1, j = b.length() - 1, carry = 0; //two pointers starting from the back, just think of adding two regular ints from you add from back
        while (i >= 0 || j >= 0) {
            int sum = carry; //if there is a carry from the last addition, add it to carry
            if (j >= 0) sum += b.charAt(j--) - '0'; //we subtract '0' to get the int value of the char from the ascii
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2); //if sum==2 or sum==0 append 0 cause 1+1=0 in this case as this is base 2 (just like 1+9 is 0 if adding ints in columns)
            carry = sum / 2; //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
        }
        if (carry != 0) sb.append(carry); //leftover carry, add it
        return sb.reverse().toString();
    }

    /**
     * Time O(max(a,b))
     * Space O(max(a,b))
     */
    public String addBinary(String str1, String str2) {
        int i = str1.length() - 1, j = str2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                int num1 = str1.charAt(i--) - '0';
                int num2 = str2.charAt(j--) - '0';
                int val = num1 ^ num2;
                if (carry != 0) {
                    val ^= carry;
                    if (val != 0) {
                        carry = 0;
                    }
                }
                if (num1 == 1 && num2 == 1) {
                    carry = 1;
                }
                sb.append(val);
            } else if (i >= 0) {
                int num = str1.charAt(i--) - '0';
                if (carry != 0) {
                    num = num ^ carry;
                    if (num != 0) {
                        carry = 0;
                    }
                }
                sb.append(num);
            } else {
                int num = str2.charAt(j--) - '0';
                if (carry != 0) {
                    num = num ^ carry;
                    if (num != 0) {
                        carry = 0;
                    }
                }
                sb.append(num);
            }
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
