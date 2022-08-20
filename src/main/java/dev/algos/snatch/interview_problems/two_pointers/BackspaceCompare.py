class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        i, j, rm_i, rm_j = len(s) - 1, len(t) - 1, 0, 0
        while i >= 0 and j >= 0:
            if s[i] == '#':
                rm_i += 1
                i -= 1
            elif rm_i > 0:
                i -= rm_i
                rm_i = 0
            if t[j] == '#':
                j -= 1
                rm_j += 1
            elif rm_j > 0:
                j -= rm_j
                rm_j = 0
            if s[i] != '#' and t[j] != '#' and rm_j == 0 and rm_i == 0 and s[i] != t[j]:
                return False
            elif s[i] != '#' and t[j] != '#' and rm_j == 0 and rm_i == 0 and s[i] == t[j]:
                i -= 1
                j -= 1
        return i - rm_i < 0 and j - rm_j < 0


Solution().backspaceCompare("ab##", "c#d#")
