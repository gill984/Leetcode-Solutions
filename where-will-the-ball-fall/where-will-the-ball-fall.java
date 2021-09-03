class Solution {
    int m;
    int n;
    
    public int[] findBall(int[][] grid)
    {
        m = grid.length;
        n = grid[0].length;
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        int [] res = new int [n];
        for (int i = 0; i < n; i++)
            res[i] = canReachBottom(grid, 0, i, memo);
        return res;
    }
    
    public int canReachBottom(int[][] grid, int row, int col, Map<Integer, Integer> memo)
    {
        if (row == m)
            return col;
        
        int key = hash(row, col);
        if (memo.containsKey(key))
            return memo.get(key);
        else if (col <= n - 2 && grid[row][col] == 1 && grid[row][col + 1] == 1)
            memo.put(key, canReachBottom(grid, row + 1, col + 1, memo));
        else if (col >= 1 && grid[row][col] == -1 && grid[row][col - 1] == -1)
            memo.put(key, canReachBottom(grid, row + 1, col - 1, memo));
        else
            memo.put(key, -1);
        
        return memo.get(key);
    }
    
    public int hash(int row, int col)
    {
        return row + (col * m);
    }
}