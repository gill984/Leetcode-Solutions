class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        res = 0
        heads = [[] for i in range(26)]
        
        for w in words:
            heads[ord(w[0]) - ord('a')].append((w, 0))
        
        for c in s:
            cWords = heads[ord(c) - ord('a')]
            heads[ord(c) - ord('a')] = []
            
            for cWord in cWords:
                if cWord[1] + 1 == len(cWord[0]):
                    res += 1
                else:
                    nextWord = (cWord[0], cWord[1] + 1)
                    heads[ord(nextWord[0][nextWord[1]]) - ord('a')].append(nextWord)
        
        return res