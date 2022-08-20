from collections import defaultdict
import collections


def longestPalindrome(s: str) -> int:
    store = defaultdict(0)
    for c in s:
        store[c] += 1
    ans = 0
    max_odd = 0
    for c, cnt in store.items():
        if cnt % 2 == 0:
            ans += cnt
        else:
            max_odd = max(max_odd, cnt)
    return ans + max_odd


def longestPalindrome2(s: str) -> int:
    odds = sum(v & 1 for v in collections.Counter(s).values())
    return len(s) - odds + bool(odds)


print(longestPalindrome2("abccccdd"))
