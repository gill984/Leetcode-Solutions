class Solution {    
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<Integer>();
        List<Integer> cols = new ArrayList<Integer>();
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[0].length; col++)
                if (grid[row][col] == 1)
                    rows.add(row);
        
        for (int col = 0; col < grid[0].length; col++)
            for (int row = 0; row < grid.length; row++)
                if (grid[row][col] == 1)
                    cols.add(col);
        
        int rowMedian = 0;
        int colMedian = 0;
        
        rowMedian = rows.get(rows.size() / 2);
        colMedian = cols.get(cols.size() / 2);
        
        int res = 0;
        for (int i = 0; i < rows.size(); i++)
        {
            res += Math.abs(rowMedian - rows.get(i));
            res += Math.abs(colMedian - cols.get(i));
        }
        
        return res;
    }
}