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
                res.get(row).add(grid[source / n][source % n]);
                source = (source + 1) % (m * n);
            }
        }
        
        return res;
    }
}