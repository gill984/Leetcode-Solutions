class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = (1 << i & a) > 0 ? 1 : 0;
            int bBit = (1 << i & b) > 0 ? 1 : 0;
            int cBit = (1 << i & c) > 0 ? 1 : 0;
            
            if (cBit == 0) {
                res += aBit + bBit;
            } else if (aBit != cBit && bBit != cBit) {
                res++;
            }
        }
        
        return res;
    }
}