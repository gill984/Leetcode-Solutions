class Solution {
    final int WALL = 1;
    final int VISITED = 2;
    
    int[][] dirs = new int [][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Path begin = new Path(start[0], start[1], 0);
        PriorityQueue<Path> paths = new PriorityQueue<Path>();
        paths.offer(begin);
        return dijkstra(maze, paths, destination);
    }
    
    public int dijkstra(int[][] maze, PriorityQueue<Path> paths, int[] destination)
    {
        // No more paths
        if(paths.isEmpty())
            return -1;
        
        Path p = paths.poll();
        maze[p.row][p.col] = VISITED;
        
        if(p.row == destination[0] && p.col == destination[1])
            return p.length;
        
        for(int i = 0; i < dirs.length; i++)
        {
            int count = 0;
            int nbrRow = p.row;
            int nbrCol = p.col;
            while(nbrRow + dirs[i][0] >= 0 && nbrRow + dirs[i][0] < maze.length &&
                  nbrCol + dirs[i][1] >= 0 && nbrCol + dirs[i][1] < maze[0].length &&
                  maze[nbrRow + dirs[i][0]][nbrCol + dirs[i][1]] != WALL)
            {
                nbrRow += dirs[i][0];
                nbrCol += dirs[i][1];
                count++;
            }
            
            if(maze[nbrRow][nbrCol] != VISITED)
                paths.offer(new Path(nbrRow, nbrCol, p.length + count));
        }
        
        return dijkstra(maze, paths, destination);
    }
}

class Path implements Comparable
{
    int row;
    int col;
    int length;
    
    public Path(int r, int c, int l)
    {
        row = r;
        col = c;
        length = l;
    }

    public int compareTo(Object o)
    {
        Path p = (Path) o;
        return Integer.compare(length, p.length);
    }
}