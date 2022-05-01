class Solution {
    public int[] findPermutation(String ss) {
        char [] s = ss.toCharArray();
        int idx = 0;
        int [] res = new int [s.length + 1];
        int curr = 1;
        
        while (idx < s.length) {
            char c = s[idx];
            if (c == 'I') {
                res[idx] = curr;
                curr++;
            } else {
                int dCount = 1;
                while (idx + dCount < s.length && s[idx + dCount] == 'D') {
                    dCount++;
                }
                
                for (int i = dCount; i >= 0; i--) {
                    res[idx + i] = curr;
                    curr++;
                }
                idx = idx + dCount;
            }
            idx++;
        }
        
        if (idx < res.length)
            res[idx] = curr;
        
        return res;
    }
}