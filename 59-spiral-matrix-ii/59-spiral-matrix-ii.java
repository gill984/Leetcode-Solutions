class Solution
{
    // RIGHT, DOWN, LEFT, UP
    int ROW_IDX = 0;
    int COL_IDX = 1;
    int [] right = {0, 1};
    int [] down = {1, 0};
    int [] left = {0, -1};
    int [] up = {-1, 0};
    int [][] DIRECTION = {right, down, left, up};
    public int[][] generateMatrix(int n)
    {
        // Fill matrix with 1-n^2 in spiral order
        // Observations:
        //   n will be the length of the rows and the columns
        int[][] res = new int[n][n];
        int row = 0;
        int col = 0;
        int dir = 0;
        for(int i = 1; i <= n * n; i++)
        {
            res[row][col] = i;
            
            // Find the next square to go to by updating row and col
            // Try the current direction we are heading
            // if that doesn't work try the next directions in order
            for(int j = 0; j < DIRECTION.length; j++)
            {
                dir = (j + dir) % DIRECTION.length;
                int nextRow = DIRECTION[dir][ROW_IDX] + row;
                int nextCol = DIRECTION[dir][COL_IDX] + col;
                
                // Check bounds and make sure we didn't already put a value in this spot
                if(nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n)
                {
                    if(res[nextRow][nextCol] != 0)
                    {
                        continue;
                    }
                    else
                    {
                        row = nextRow;
                        col = nextCol;
                        break;
                    }
                }
            }
        }
        
        return res;
    }
}