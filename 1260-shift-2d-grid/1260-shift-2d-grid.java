class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int source = Math.floorMod(-k, m * n);
        
        for (int row = 0; row < m; row++)
        {
            List<Integer> l = new ArrayList<>();
            for (int col = 0; col < n; col++, source = (source + 1) % (m * n))
            {
                // find out what should go at res[row][col]
                l.add(grid[source / n][source % n]);
            }
            res.add(l);
        }
        
        return res;
    }
}