class Solution {
    public int trailingZeroes(int n) {
        // Determine how many 2s and 5s there are as we go
        int twoCount = 0;
        int fiveCount = 0;
        for (int i = 1; i <= n; i++)
        {
            int temp = i;
            while (temp % 2 == 0)
            {
                temp /= 2;
                twoCount++;
            }
            
            while (temp % 5 == 0)
            {
                temp /= 5;
                fiveCount++;
            }
        }
        
        return Math.min(twoCount, fiveCount);
    }
}