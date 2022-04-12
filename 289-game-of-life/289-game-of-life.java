class Solution {
    int WAS_ZERO_NOW_ONE = 2;
    int WAS_ONE_NOW_ZERO = 3;
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int [][] result = new int [m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = nextState(board, row, col);
            }
        }
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == WAS_ZERO_NOW_ONE)
                {
                    board[row][col] = 1;
                }
                else if (board[row][col] == WAS_ONE_NOW_ZERO)
                {
                    board[row][col] = 0;
                }
            }
        }
    }
    
    public int nextState(int[][] board, int row, int col) {
        int nbrs = numNeighbors(board, row, col);
        if (board[row][col] == 0)
        {
            if (nbrs == 3)
                return WAS_ZERO_NOW_ONE;
            else
                return 0;
        }
        else
        {
            if (nbrs == 2 || nbrs == 3)
                return 1;
            else
                return WAS_ONE_NOW_ZERO;
        }
    }
    
    public int numNeighbors (int [][] board, int row, int col)
    {
        int res = 0;
        for (int rd = -1; rd <= 1; rd++) {
            for (int cd = -1; cd <= 1; cd++) {
                // Skip same cell check
                if (rd == 0 && cd == 0)
                    continue;
                
                if (row + rd >= 0 && row + rd < board.length &&
                    col + cd >= 0 && col + cd < board[0].length &&
                    (board[row + rd][col + cd] == 1 || board[row + rd][col + cd] == WAS_ONE_NOW_ZERO))
                {
                    res++;
                }
            }
        }
        
        return res;
    }
}