class Solution {
    int minRow;
    int minCol;
    int maxRow;
    int maxCol;
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minArea(char[][] image, int x, int y) {
        minRow = x;
        maxRow = x;
        minCol = y;
        maxCol = y;
        dfs(image, x, y);
        
        return (Math.abs(maxRow - minRow + 1) * Math.abs(maxCol - minCol + 1));
    }
    
    public void dfs(char[][] image, int row, int col)
    {
        if (image[row][col] == '1')
        {
            minRow = Math.min(minRow, row);
            minCol = Math.min(minCol, col);
            maxRow = Math.max(row, maxRow);
            maxCol = Math.max(col, maxCol);
            image[row][col] = '2';
        }
        else
        {
            return;
        }
        
        for (int [] dir : dirs)
        {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            
            if (nextRow >= 0 && nextCol >= 0 && nextRow < image.length && nextCol < image[0].length)
            {
                dfs(image, nextRow, nextCol);
            }
        }
    }
}