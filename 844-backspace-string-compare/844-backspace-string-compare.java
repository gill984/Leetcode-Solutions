class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sdx = s.length() - 1;
        int tdx = t.length() - 1;
        
        while (sdx >= 0 || tdx >= 0)
        {
            int bs = 0;
            while (sdx >= 0) {
                if (s.charAt(sdx) == '#') {
                    bs++;
                } else if (bs == 0) {
                    break;
                } else {
                    bs--;
                }
                sdx--;
            }
            
            bs = 0;
            while (tdx >= 0) {
                if (t.charAt(tdx) == '#') {
                    bs++;
                } else if (bs == 0) {
                    break;
                } else {
                    bs--;
                }
                tdx--;
            }
            
            if (tdx < 0 && sdx < 0)
                return true;
            else if (tdx < 0)
                return false;
            else if (sdx < 0)
                return false;
            else if (s.charAt(sdx) != t.charAt(tdx))
                return false;
            sdx--;
            tdx--;
        }
        
        return true;
    }
}