class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int source = Math.floorMod(-k, m * n);
        
        for (int row = 0; row < m; row++)
        {
            res.add(new ArrayList<>());
            for (int col = 0; col < n; col++)
            {
                // find out what should go at res[row][col]
                int [] sourcePoint = toTwoDim(source, n);
                res.get(row).add(grid[sourcePoint[0]][sourcePoint[1]]);
                source = (source + 1) % (m * n);
            }
        }
        
        return res;
    }
    
    public int[] toTwoDim(int x, int n)
    {
        int row = x / n;
        int col = x % n;
        return new int [] {row, col};
    }
}