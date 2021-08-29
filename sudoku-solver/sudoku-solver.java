class Solution
{
    int LENGTH = 9;
    public void solveSudoku(char[][] board)
    {
        dfs(board, 0, 0);
    }
    
    public boolean dfs(char[][] board, int row, int col)
    {
        char c = board[row][col];
        if(c != '.')
        {
            if(row == LENGTH - 1 && col == LENGTH - 1)
                return true;
            else if(col == LENGTH - 1)
                return dfs(board, row + 1, 0);
            else
                return dfs(board, row, col + 1);
        }
        
        boolean[] invalidChars = getInvalidNumbers(board, row, col);
        for(char i = '1'; i <= '9'; i++)
        {
            if(!invalidChars[i - '1'])
            {
                board[row][col] = i;
                boolean attempt = false;
                
                if(row == LENGTH - 1 && col == LENGTH - 1)
                    attempt = true;
                else if(col == LENGTH - 1)
                    attempt = dfs(board, row + 1, 0);
                else
                    attempt = dfs(board, row, col + 1);
                
                if(attempt)
                    return true;
                else
                    board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    public boolean[] getInvalidNumbers(char[][] board, int row, int col)
    {
        boolean[] result = new boolean[LENGTH];
        for(int i = 0; i < LENGTH; i++)
        {
            if(board[row][i] != '.') result[board[row][i] - '1'] = true;
            if(board[i][col] != '.') result[board[i][col] - '1'] = true;
        }
        int squareCol = (col / 3) * 3;
        int squareRow = (row / 3) * 3;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                char c = board[squareRow + i][squareCol + j];
                if(c != '.')
                    result[c - '1'] = true;
            }
        }
        return result;
    }
}