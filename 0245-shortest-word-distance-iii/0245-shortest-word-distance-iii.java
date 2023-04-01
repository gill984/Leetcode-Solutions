class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        boolean assignOne = true;
        boolean sameWord = word1.equals(word2);
        
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            
            if (sameWord && s.equals(word1)) {
                if (assignOne)
                    idx1 = i;
                else
                    idx2 = i;
                
                assignOne = !assignOne;
            }
            
            if (!sameWord && s.equals(word1))
                idx1 = i;
            
            if (!sameWord && s.equals(word2))
                idx2 = i;
            
            if (idx1 != -1 && idx2 != -1)
                res = Math.min(res, Math.abs(idx1 - idx2));
        }
        
        return res;
    }
}