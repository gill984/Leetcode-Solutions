class Solution {
                                        // UP,    RIGHT,  DOWN,   LEFT
    public int [][] dirs = new int [][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;
    
    public void cleanRoom(Robot robot)
    {
        this.robot = robot;
        backtrack(0, 0, 0);
    }
    
    public void backtrack(int row, int col, int d)
    {
        visited.add(new Pair(row, col));
        robot.clean();
        for (int i = 0; i < 4; i++)
        {
            int nextDir = (d + i) % 4;
            int nextRow = row + dirs[nextDir][0];
            int nextCol = col + dirs[nextDir][1];
            
            if (!visited.contains(new Pair(nextRow, nextCol)) && robot.move())
            {
                backtrack(nextRow, nextCol, nextDir);
                goBack();
            }
            
            robot.turnRight();
        }
    }
    
    public void goBack()
    {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}