from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        s_arr, p_arr, ans = [0 for _ in range(26)], [0 for _ in range(26)], []
        for c in p:
            p_arr[ord(c) - 97] += 1
        for i in range(len(s)):
            s_arr[ord(s[i]) - 97] += 1
            if i >= len(p) - 1:
                found = True
                for j in range(26):
                    if s_arr[j] != p_arr[j]:
                        found = False
                        break
                if found:
                    ans.append(i - len(p) + 1)
                s_arr[ord(s[i - len(p) + 1]) - 97] -= 1
        return ans


print(Solution().findAnagrams("cbaebabacd", "abc"))
