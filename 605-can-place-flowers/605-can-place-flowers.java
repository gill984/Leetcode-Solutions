class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Can greedily plant flowers
        // Can plant a flower if the surrounding 2 indices do not have flowers, or are OOB
        int count = 0;
        
        for (int i = 0; i < flowerbed.length; i++)
        {
            // Check left and right
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                ((i == flowerbed.length - 1) || flowerbed[i + 1] == 0))
            {
                count += 1;
                flowerbed[i] = 1;
            }
        }
        
        return (count >= n);
    }
}