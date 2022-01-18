class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        
        for (int i = 0; i < flowerbed.length && count < n;)
        {        
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                ((i == flowerbed.length - 1) || flowerbed[i + 1] == 0))
            {
                count += 1;
                flowerbed[i] = 1;
                i += 2;
            }
            else if (flowerbed[i] == 1)
            {
                i += 2;
            }
            else
            {
                i++;
            }
        }
        
        return (count >= n);
    }
}