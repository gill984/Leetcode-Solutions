class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        
        for (int length = 1; length <= k; length++)
        {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0)
                return length;
        }
        
        return -1;
    }
}