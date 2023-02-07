
class Solution {
    public int totalFruit(int[] fruits) {
        int nextLo = 0;
        int n = fruits.length;
        if (n == 1)
            return 1;
        int res = 2;
        
        while (nextLo < n)
        {
            int lo = nextLo;
            int hi = lo + 1;
            int first = fruits[lo];
            int second = -1;
            while (hi < n)
            {
                if (fruits[hi] == first)
                {
                    if (second != -1 && fruits[nextLo] != first)
                        nextLo = hi;
                    hi++;
                }
                else if (fruits[hi] == second)
                {
                    if (fruits[nextLo] != second)
                        nextLo = hi;
                    hi++;
                }
                else if (second != -1 && fruits[hi] != second)
                {
                    hi--;
                    res = Math.max(hi - lo + 1, res);
                    break;
                }
                else if (second == -1)
                {
                    second = fruits[hi];
                    nextLo = hi;
                    hi++;
                }
            }
            
            if (hi == n)
            {
                res = Math.max(hi - lo, res);
                break;
            }
        }
        
        
        return res;
    }
}