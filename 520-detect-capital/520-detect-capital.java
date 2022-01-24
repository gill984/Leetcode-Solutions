class Solution {
    public boolean detectCapitalUse(String word) {
        boolean allCaps = true;
        boolean allLower = true;
        boolean onlyFirst = true;
        char [] w = word.toCharArray();
        
        for (int i = 0; i < w.length; i++)
        {
            char c = w[i];
            if (c >= 'a' && c <= 'z')
            {
                allCaps = false;
                if (i == 0)
                {
                    onlyFirst = false;
                }
            }
            
            if (c >= 'A' && c <= 'Z')
            {
                allLower = false;
                if (i != 0)
                {
                    onlyFirst = false;
                }
            }
        }
        
        return allCaps || allLower || onlyFirst;
    }
}