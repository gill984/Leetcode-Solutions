class Solution {
    int [][] dirs = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int[][] generateMatrix(int n) {
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        
        int [][] res = new int [n][n];
        int row = 0;
        int col = 0;
        int dir = 0;
        
        for (int step = 0; step < n * n; step++) {
            res[row][col] = step + 1;
            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];
            
            if (nextRow < top) {
                left += 1;
                dir = (dir + 1) % 4;
            } else if (nextRow > bottom) {
                right -= 1;
                dir = (dir + 1) % 4;
            } else if (nextCol < left) {
                bottom -= 1;
                dir = (dir + 1) % 4;
            } else if (nextCol > right) {
                top += 1;
                dir = (dir + 1) % 4;
            }
            
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        
        return res;
    }
}