class Solution {
    // flags for visited and in which direction
    final int R = 2;
    final int D = 4;
    final int DR = 8;
    final int DL = 16;
    
    int res = 0;
    
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] != 0)
                {
                    // Can be visited in 3 different ways, try all 3
                    if ((mat[i][j] & R) == 0)
                        dfs(mat, i, j, m, n, R, 0);
                    if ((mat[i][j] & D) == 0)
                        dfs(mat, i, j, m, n, D, 0);
                    if ((mat[i][j] & DR) == 0)
                        dfs(mat, i, j, m, n, DR, 0);
                    if ((mat[i][j] & DL) == 0)
                        dfs(mat, i, j, m, n, DL, 0);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] mat, int row, int col, int m, int n, int dir, int d)
    {
        mat[row][col] += dir;
        d += 1;
        res = Math.max(d, res);
        
        int nextRow = row;
        int nextCol = col;
        
        if (dir == D)
            nextRow += 1;
        else if (dir == R)
            nextCol += 1;
        else if (dir == DR)
        {
            nextRow += 1;
            nextCol += 1;
        }
        else
        {
            nextRow += 1;
            nextCol -= 1;
        }
        
        if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && mat[nextRow][nextCol] > 0)
            dfs(mat, nextRow, nextCol, m, n, dir, d);
    }
}