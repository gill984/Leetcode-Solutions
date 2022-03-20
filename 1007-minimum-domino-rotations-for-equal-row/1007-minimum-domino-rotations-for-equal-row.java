class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        
        // Top row same as top[0]
        int res = Integer.MAX_VALUE;
        int target = tops[0];
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (tops[i] == target)
            {
                continue;
            }
            else if (bottoms[i] == target)
            {
                count++;
            }
            else
            {
                count = -1;
                break;
            }
        }
        
        res = (count != -1 ? Math.min(res, count) : res);
        
        count = 0;
        target = bottoms[0];
        for (int i = 0; i < n; i++)
        {
            if (bottoms[i] == target)
            {
                continue;
            }
            else if (tops[i] == target)
            {
                count++;
            }
            else
            {
                count = -1;
                break;
            }
        }
        res = (count != -1 ? Math.min(res, count) : res);
        
        count = 0;
        target = tops[0];
        for (int i = 0; i < n; i++)
        {
            if (bottoms[i] == target)
            {
                continue;
            }
            else if (tops[i] == target)
            {
                count++;
            }
            else
            {
                count = -1;
                break;
            }
        }
        res = (count != -1 ? Math.min(res, count) : res);
        
        count = 0;
        target = bottoms[0];
        for (int i = 0; i < n; i++)
        {
            if (tops[i] == target)
            {
                continue;
            }
            else if (bottoms[i] == target)
            {
                count++;
            }
            else
            {
                count = -1;
                break;
            }
        }
        res = (count != -1 ? Math.min(res, count) : res);
        
        return (res == Integer.MAX_VALUE ? -1 : res);
    }
}