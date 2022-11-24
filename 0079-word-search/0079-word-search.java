class Solution {
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char [] w = word.toCharArray();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == w[0])
                    if (dfs(board, w, i, j, 1))
                        return true;
        
        return false;
    }
    
    public boolean dfs (char[][] board, char[] w, int row, int col, int wIdx)
    {
        int m = board.length;
        int n = board[0].length;
        if (wIdx == w.length)
            return true;
        
        char temp = board[row][col];
        board[row][col] = '0';
        
        for (int[] dir : dirs)
        {
            int nbrRow = row + dir[0];
            int nbrCol = col + dir[1];
            
            if (nbrRow >= 0 && nbrRow < m && nbrCol >= 0 && nbrCol < n)
            {
                if (board[nbrRow][nbrCol] == w[wIdx])
                {
                    boolean complete = dfs(board, w, nbrRow, nbrCol, wIdx + 1);
                    if (complete)
                        return true;
                }
            }
        }
        
        board[row][col] = temp;
        return false;
    }
}