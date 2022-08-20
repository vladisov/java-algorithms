from typing import List

'''
  Input: s = "abc", shifts = [3,5,9]
  Output: "rpl"
  Explanation: We start with "abc".
  After shifting the first 1 letters of s by 3, we have "dbc".
  After shifting the first 2 letters of s by 5, we have "igc".
  After shifting the first 3 letters of s by 9, we have "rpl", the answer.
 
 
  Time O(N)
  Space O(1) (no axil
'''


class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        for i in range(2, len(shifts) + 1):
            shifts[-i] += shifts[-i + 1]
        ans = ""
        for i in range(0, len(s)):
            ans += chr(97 + (ord(s[i]) - 97 + shifts[i]) % 26)
        return ans

    def shiftingLettersZip(self, s: str, shifts: List[int]) -> str:
        for i in range(2, len(shifts) + 1):
            shifts[-i] += shifts[-i + 1]
        return "".join(chr(97 + (ord(c) - 97 + shift) % 26) for c, shift in zip(s, shifts))


Solution().shiftingLetters("abc", [3, 5, 9])
