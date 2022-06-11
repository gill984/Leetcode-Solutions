class WordDistance {

    Map<String, List<Integer>> wordToIndices = new HashMap<>();
    
    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            wordToIndices.putIfAbsent(wordsDict[i], new ArrayList<>());
            wordToIndices.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> nums1 = wordToIndices.get(word1);
        List<Integer> nums2 = wordToIndices.get(word2);
        
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < nums1.size() && j < nums2.size(); i++) {
            int num1 = nums1.get(i);
            int num2 = nums2.get(j);
            int diff = Math.abs(num1 - num2);
            
            if (num1 > num2) {
                while (j + 1 < nums2.size()) {
                    int newDiff = Math.abs(nums2.get(j + 1) - num1);
                    if (diff >= newDiff) {
                        j++;
                        diff = newDiff;
                    } else {
                        break;
                    }
                }
            }
            
            
            res = Math.min(diff, res);
        }
        
        // System.out.println(res);
        
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */