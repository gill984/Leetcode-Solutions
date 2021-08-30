class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int rowMax = m;
        int colMax = n;
        
        for (int[] op : ops)
        {
            rowMax = Math.min(rowMax, op[0]);
            colMax = Math.min(colMax, op[1]);
        }
        
        return rowMax * colMax;
    }
}