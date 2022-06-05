class Solution {
    int n;
    int usedCols = 0, usedDiagDown = 0, usedDiagUp = 0, res = 0;
    
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0);
        return res;
    }
    
    public void dfs (int row) {
        for (int col = 0; col < n; col++) {
            if (isUsed(row, col))
                continue;

            flipUseBits(row, col);

            if (row == n - 1)
                res++;
            else
                dfs (row + 1);

            flipUseBits(row, col);
        }
    }
    
    private boolean isUsed (int row, int col) {
        return (usedCols & 1 << col) != 0 || (usedDiagDown & 1 << (n - 1 - row + col)) != 0 || (usedDiagUp & (1 << (row + col))) != 0;
    }
    
    private void flipUseBits (int row, int col) {
        usedCols ^= (1 << col);
        usedDiagDown ^= (1 << (n - 1 - row + col));
        usedDiagUp ^= (1 << (row + col));
    }
}