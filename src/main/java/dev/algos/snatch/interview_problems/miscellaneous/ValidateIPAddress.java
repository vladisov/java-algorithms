package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * <p>
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * <p>
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * <p>
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * <p>
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * <p>
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * <p>
 * Note: You may assume there is no extra space or special characters in the input string.
 * <p>
 * Example 1:
 * Input: "172.16.254.1"
 * <p>
 * Output: "IPv4"
 * <p>
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * Output: "IPv6"
 * <p>
 * Explanation: This is a valid IPv6 address, return "IPv6".
 */
public class ValidateIPAddress {

    /**
     * Time O(N)
     * Space O(1)
     */
    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) {
            return "Neither";
        }
        boolean ipv4 = IP.contains(".");
        boolean ipv6 = IP.contains(":");
        if (ipv4 && ipv6 || (!ipv4 && !ipv6)) {
            return "Neither";
        }
        if (ipv4 && validateIpv4(IP)) {
            return "IPv4";
        }
        if (ipv6 && validateIpv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    boolean validateIpv4(String ip) {
        if (ip.startsWith(".") || ip.endsWith(".")) return false;
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        for (var part : parts) {
            if (!parseInt(part)) {
                return false;
            }
        }
        return true;
    }

    boolean parseInt(String part) {
        if (part.isEmpty() || part.length() > 3) return false;
        boolean leadingZeros = false;
        int i = 0, num = 0;
        while (i < part.length() && part.charAt(i) == '0') {
            leadingZeros = true;
            i++;
        }
        if (i > 0 && part.length() > 1 && leadingZeros) return false;
        while (i < part.length()) {
            char c = part.charAt(i++);
            if (!Character.isDigit(c)) {
                return false;
            }
            num = num * 10 + (c - '0');
        }
        return num <= 255;
    }

    boolean validateIpv6(String ip) {
        if (ip.startsWith(":") || ip.endsWith(":")) return false;
        String[] parts = ip.split(":");
        if (parts.length != 8) return false;
        for (var part : parts) {
            if (!parseHex(part)) {
                return false;
            }
        }
        return true;
    }

    boolean parseHex(String part) {
        if (part.isEmpty() || part.length() > 4) return false;
        part = part.toLowerCase();
        int i = 0;
        while (i < part.length()) {
            char c = part.charAt(i++);
            if (!Character.isDigit(c) && !(c >= 'a' && c <= 'f')) {
                return false;
            }
        }
        return true;
    }
}
