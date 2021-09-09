class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        List<TreeSet<Integer>> rowMines = new ArrayList<TreeSet<Integer>>();
        List<TreeSet<Integer>> colMines = new ArrayList<TreeSet<Integer>>();
        
        for (int i = 0; i < n; i++)
        {
            rowMines.add(new TreeSet<Integer>());
            colMines.add(new TreeSet<Integer>());
        }
        
        for (int[] mine : mines)
        {
            rowMines.get(mine[0]).add(mine[1]);
            colMines.get(mine[1]).add(mine[0]);
        }
        
        // System.out.println(rowMines);
        // System.out.println(colMines);
        
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                res = Math.max(res, largestPlus(i, j, rowMines.get(i), colMines.get(j), n));
            }
        }
        
        return res;
    }
    
    public int largestPlus(int row, int col, TreeSet<Integer> rowMines, TreeSet<Integer> colMines, int n)
    {
        int leftMine = (rowMines.floor(col) != null) ? rowMines.floor(col) : -1;
        int rightMine = (rowMines.ceiling(col) != null) ? rowMines.ceiling(col) : n;
        int upMine = (colMines.floor(row) != null) ? colMines.floor(row) : -1;
        int downMine = (colMines.ceiling(row) != null) ? colMines.ceiling(row) : n;
        int res = min4(col - leftMine, rightMine - col, row - upMine, downMine - row);
        
        // System.out.println("Row: " + row + ", Col: " + col + "(" + leftMine + ", " + rightMine + ", " +  upMine + ", " +  downMine + ") => " + res);
        
        return res;
    }
    
    public int min4(int a, int b, int c, int d)
    {
        return Math.min(a, Math.min(b, Math.min(c, d)));
    }
}