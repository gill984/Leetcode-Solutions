class Solution {
    public int compress(char[] s) {
        int compressIdx = 0;
        int prevCount = 0;
        
        for (int sdx = 0; sdx < s.length; sdx++)
        {
            if (sdx > 0 && s[sdx - 1] == s[sdx])
            {
                prevCount++;
            }
            else
            {
                if (prevCount > 1)
                {
                    String sCount = "" + prevCount;
                    for (int i = 0; i < sCount.length(); i++)
                        s[compressIdx++] = sCount.charAt(i);
                }
                s[compressIdx++] = s[sdx];
                prevCount = 1;
            }
        }
        
        if (prevCount > 1)
        {
            String sCount = "" + prevCount;
            for (int i = 0; i < sCount.length(); i++)
                s[compressIdx++] = sCount.charAt(i);
        }
        
        return compressIdx;
    }
}