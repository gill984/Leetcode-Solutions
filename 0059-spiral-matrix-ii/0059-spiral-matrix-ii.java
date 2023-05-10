class Solution {
    int [][] dirs = new int [][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int [][] boundChange = new int [][] {{1, 0, 0, 0}, {0, -1, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, 1}};
    int [] bounds;
    
    public int[][] generateMatrix(int n) {
        int [] bounds = new int [] {0, n - 1, n - 1, 0};
        int [][] res = new int [n][n];
        int row = 0;
        int col = 0;
        int dir = 0;
        
        for (int step = 0; step < n * n; step++) {
            res[row][col] = step + 1;
            int nextRow = row + dirs[dir][0];
            int nextCol = col + dirs[dir][1];
            
            if (nextRow < bounds[0] || nextRow > bounds[2] || nextCol > bounds[1] || nextCol < bounds[3]) {
                for (int i = 0; i < 4; i++) {
                    bounds[i] += boundChange[dir][i];
                }
                dir = (dir + 1) % 4;
            }
            
            row += dirs[dir][0];
            col += dirs[dir][1];
        }
        
        return res;
    }
}