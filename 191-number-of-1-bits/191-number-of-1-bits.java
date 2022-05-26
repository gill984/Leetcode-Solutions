public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++)
            res += ((1 << i & n) != 0) ? 1 : 0;
        
        return res;
    }
}