class Solution {
    public int shortestWay(String source, String target) {
        // Track smallest number of subsequences
        int tdx = 0;
        boolean usedChar = true;
        for (int res = 1; usedChar; res++) {
            usedChar = false;
            
            for (char s : source.toCharArray()) {
                if (s == target.charAt(tdx)) {
                    tdx++;
                    usedChar = true;
                }
                
                if (tdx == target.length())
                    return res;
            }
        }
        return -1;
    }
}