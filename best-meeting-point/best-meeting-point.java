class Solution {    
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        for (int row = 0; row < grid.length; row++)
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                if (grid[row][col] == 1)
                {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        
        Collections.sort(rows);
        Collections.sort(cols);
        int rowMedian = 0;
        int colMedian = 0;
        for (int lo = 0, hi = rows.size() - 1; lo <= hi; lo++, hi--)
        {
            rowMedian = (rows.get(lo) + rows.get(hi)) / 2;
            colMedian = (cols.get(lo) + cols.get(hi)) / 2;
        }
        
        // System.out.println(rowMedian);
        // System.out.println(colMedian);
        
        int res = 0;
        for (int i = 0; i < rows.size(); i++)
        {
            res += Math.abs(rowMedian - rows.get(i));
            res += Math.abs(colMedian - cols.get(i));
        }
        
        return res;
    }
}