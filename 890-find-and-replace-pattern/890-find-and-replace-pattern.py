class Solution:
    def findAndReplacePattern(self, words: List[str], pattern: str) -> List[str]:
        # map first character to a, second to b, and so on
        res = []
        standard_pattern = self.standardize(pattern)
        for word in words:
            if self.standardize(word) == standard_pattern:
                res.append(word)
        return res
        
    def standardize(self, s):
        d = {}
        res = []
        i = ord('a')
        for c in s:
            if c in d:
                res.append(d[c])
            else:
                res.append(chr(i))
                d[c] = chr(i)
                i += 1
        return res
                
                