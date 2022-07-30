class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        res = []
        count2 = Counter()
        for word in words2:
            count2 |= Counter(word)
        for word in words1:
            count1 = Counter(word)
            if count1 >= count2:
                res.append(word)
                
        return res