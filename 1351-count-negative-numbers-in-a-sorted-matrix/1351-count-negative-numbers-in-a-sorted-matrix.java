class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int col = 0;
        
        for (int row = m - 1; row >= 0 && col < n; row--) {
            while (col < n && grid[row][col] >= 0)
                col++;
            count += (n - col);
        }
        
        return count;
    }
}