class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sd = {}
        td = {}
        for c in s:
            sd[c] = 1 + (sd[c] if c in sd else 0)
        
        for c in t:
            td[c] = 1 + (td[c] if c in td else 0)

        return sd == td