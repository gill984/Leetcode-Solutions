class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int curMinVal = 0;
        int curMinIdx = 0;
        int curSecondMinVal = 0;
        int prevMinIdx = 0;
        int prevMinVal = 0;
        int prevSecondMinVal = 0;
        
        for (int h = 0; h < n; h++)
        {
            for (int col = 0; col < k; col++)
            {
                int cost = costs[h][col];
                
                if (h != 0 && col != prevMinIdx)
                    cost += prevMinVal;
                else if (h != 0)
                    cost += prevSecondMinVal;

                // Update minimums
                if (col == 0 || cost < curMinVal)
                {
                    curSecondMinVal = curMinVal;
                    curMinVal = cost;
                    curMinIdx = col;
                }
                else if (col == 1 || cost < curSecondMinVal)
                {
                    curSecondMinVal = cost;
                }
            }
            
            prevMinIdx = curMinIdx;
            prevMinVal = curMinVal;
            prevSecondMinVal = curSecondMinVal;
        }
        
        return prevMinVal;
    }
}