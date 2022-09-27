class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char [] res = dominoes.toCharArray();
        int lo = 0;
        int hi = 0;
        
        while (hi < n) {
            char c = dominoes.charAt(hi);
            if (c == 'L') {
                if (dominoes.charAt(lo) == '.' || dominoes.charAt(lo) == 'L') {
                    for (int i = lo; i < hi; i++) {
                        res[i] = 'L';
                    }
                } else {
                    split(lo, hi, res);
                }
                lo = hi;
            } else if (c == 'R') {
                if (dominoes.charAt(lo) == 'R') {
                    for (int i = lo; i < hi; i++) {
                        res[i] = 'R';
                    }
                }
                lo = hi;
            }
            
            hi++;
        }
        
        if (res[lo] == 'R') {
            for (int i = lo; i < hi; i++) {
                res[i] = 'R';
            }
        }
        
        return new String(res);
    }
    
    public void split(int lo, int hi, char [] res) {
        while (lo < hi) {
            res[lo] = 'R';
            res[hi] = 'L';
            lo++;
            hi--;
        }
        
        if (hi == lo) {
            res[hi] = '.';
        }
    }
}