class Solution
{
    public int[] findBuildings(int[] heights)
    {
        // heights[0] is height of leftmost building
        int n = heights.length;
        int max = heights[n - 1];
        List<Integer> resList = new ArrayList<>();
        resList.add(n - 1);
        for (int i = n - 2; i >= 0; i--)
        {
            if (heights[i] > max)
            {
                max = heights[i];
                resList.add(i);
            }
        }
        
        int [] res = new int [resList.size()];
        for (int i = 0; i < res.length; i++)
        {
            res[i] = resList.get(resList.size() - 1 - i);
        }
        
        return res;
    }
}