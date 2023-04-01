class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;;
        int idx1 = -1;
        int idx2 = -1;
        boolean assignOne = true;
        boolean sameWord = word1.equals(word2);
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            if (s.equals(word1)) {
                
                if (!sameWord) {
                    idx1 = i;
                }
                
                if (sameWord && assignOne) {
                    idx1 = i;
                    assignOne = false;
                    if (idx1 != -1 && idx2 != -1) {
                        res = Math.min(res, Math.abs(idx1 - idx2));
                    }
                    continue;
                }
            }
            
            if (s.equals(word2)) {
                if (!sameWord) {
                    idx2 = i;
                }
                
                if (sameWord && !assignOne) {
                    idx2 = i;
                    assignOne = true;
                }
                if (idx1 != -1 && idx2 != -1) {
                    res = Math.min(res, Math.abs(idx1 - idx2));
                }
                continue;
            }
            
            if (idx1 != -1 && idx2 != -1) {
                res = Math.min(res, Math.abs(idx1 - idx2));
            }
        }
        
        return res;
    }
}