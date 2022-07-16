class Solution {
    final int MOD = 1000000007;
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        int [][] next = new int [m][n];
        next[startRow][startColumn] = 1;
        
        for (int move = 0; move < maxMove; move++) {
            int [][] curr = next;
            next = new int [m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (curr[i][j] == 0)
                        continue;
                    
                    for (int [] dir : dirs) {
                        int nextRow = i + dir[0];
                        int nextCol = j + dir[1];
                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n)
                            res = (res + curr[i][j]) % MOD;
                        else
                            next[nextRow][nextCol] = (next[nextRow][nextCol] + curr[i][j]) % MOD;
                    }
                }
                
            }
        }
        
        return res;
    }
}