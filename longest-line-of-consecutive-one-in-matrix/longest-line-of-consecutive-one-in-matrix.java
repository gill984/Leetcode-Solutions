class Solution {
    // flags to mark which direction we were going when visiting
    // Right, Down, Down-Right, Down-Left
    final int R = 1 << 1;
    final int D = 1 << 2;
    final int DR = 1 << 3;
    final int DL = 1 << 4;
    
    int res = 0;
    int m;
    int n;
    
    public int longestLine(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (mat[i][j] != 0)
                {
                    // Can be visited in 4 different ways, try all 4
                    // unless we've already tried that direction earlier
                    if ((mat[i][j] & R) == 0)
                        dfs(mat, i, j, R, 0);
                    if ((mat[i][j] & D) == 0)
                        dfs(mat, i, j, D, 0);
                    if ((mat[i][j] & DR) == 0)
                        dfs(mat, i, j, DR, 0);
                    if ((mat[i][j] & DL) == 0)
                        dfs(mat, i, j, DL, 0);
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] mat, int row, int col, int dir, int d)
    {
        mat[row][col] += dir;
        d += 1;
        res = Math.max(d, res);
        
        int nextRow = row;
        int nextCol = col;
        
        if (dir == D)
        {
            nextRow += 1;
        }
        else if (dir == R)
        {
            nextCol += 1;
        }
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
            dfs(mat, nextRow, nextCol, dir, d);
    }
}