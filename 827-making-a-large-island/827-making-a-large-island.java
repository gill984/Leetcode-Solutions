class Solution {
    int [][] dirs = new int [][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int islandNum = 2;
        Map<Integer, Integer> islandSize = new HashMap<>();
        islandSize.put(0, 0);
        
        // Label each island and put the size into the map
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfsMark(i, j, grid, islandNum, n);
                    islandSize.put(islandNum, size);
                    islandNum += 1;
                    max = Math.max(max, size);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // How big of an island can we make by changing this to a 1?
                    int size = 1;
                    Set<Integer> used = new HashSet<>();
                    for (int [] dir : dirs) {
                        int nbrRow = i + dir[0];
                        int nbrCol = j + dir[1];
                        if (nbrRow >= 0 && nbrRow < n && nbrCol >= 0 && nbrCol < n && !used.contains(grid[nbrRow][nbrCol])) {
                            size += islandSize.get(grid[nbrRow][nbrCol]);
                            used.add(grid[nbrRow][nbrCol]);
                        }
                        
                    }
                    max = Math.max(max, size);
                }
            }
        }
        
        return max;
    }
    
    public int dfsMark(int row, int col, int [][] grid, int id, int n) {
        grid[row][col] = id;
        int size = 1;
        for (int [] dir : dirs) {
            int nbrRow = row + dir[0];
            int nbrCol = col + dir[1];
            if (nbrRow >= 0 && nbrRow < n && nbrCol >= 0 && nbrCol < n && grid[nbrRow][nbrCol] == 1)
                size += dfsMark(nbrRow, nbrCol, grid, id, n);
        }
        return size;
    }
}