class Solution {
    int n;
    int res = 0;
    short usedCols = 0, usedDiagDown = 0, usedDiagUp = 0;
    
    public int totalNQueens(int n) {
        this.n = n;
        dfs((short) 0);
        return res;
    }
    
    public void dfs (short row) {
        for (short col = 0; col < n; col++) {
            if (isUsed(row, col))
                continue;

            flipUseBits(row, col);

            if (row == n - 1)
                res++;
            else
                dfs ((short) (row + 1));

            flipUseBits(row, col);
        }
    }
    
    final private boolean isUsed (short row, short col) {
        return (usedCols & 1 << col) != 0 ||
            (usedDiagDown & 1 << (n - 1 - row + col)) != 0 ||
            (usedDiagUp & (1 << (row + col))) != 0;
    }
    
    final private void flipUseBits (short row, short col) {
        usedCols ^= (1 << col);
        usedDiagDown ^= (1 << (n - 1 - row + col));
        usedDiagUp ^= (1 << (row + col));
    }
}