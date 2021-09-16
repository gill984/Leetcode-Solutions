class Solution {
    final int VISITED = 1000;
    final int [][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> spiralOrder(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = -1;
        
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while (count < m * n)
        {
            for (int [] dir : dirs)
            {
                while (row + dir[0] >= 0 && row + dir[0] < m &&
                    col + dir[1] >= 0 && col + dir[1] < n &&
                    matrix[row + dir[0]][col + dir[1]] != VISITED)
                {
                    row += dir[0];
                    col += dir[1];
                    res.add(matrix[row][col]);
                    matrix[row][col] = VISITED;
                    count++;
                }
            }
        }
        
        return res;
    }
}