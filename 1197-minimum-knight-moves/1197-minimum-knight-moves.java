class Solution {
    int MIN_BOUND = -10;
    int MAX_BOUND = 300;
    int [][] moves = new int [][] {{2, 1}, {1, 2}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    
    public int minKnightMoves(int x, int y) {
        if (x < 0)
            x = -x;
        if (y < 0)
            y = -y;
        
        boolean [][] visited = new boolean[311][311];
        Deque<int[]> next = new ArrayDeque<>();
        int [] start = new int [] {0, 0};
        visited[10][10] = true;
        next.offer(start);
        int steps = 0;
        
        while (!next.isEmpty()) {
            Deque<int[]> curr = next;
            next = new ArrayDeque<>();
            while (!curr.isEmpty()) {
                int [] cand = curr.poll();
                if (cand[0] == x && cand[1] == y) {
                    return steps;
                }

                for (int [] move : moves) {
                    int nextX = cand[0] + move[0];
                    int nextY = cand[1] + move[1];

                    if (nextX < MIN_BOUND || nextX > MAX_BOUND ||
                        nextY < MIN_BOUND || nextY > MAX_BOUND ||
                        visited[nextX + 10][nextY + 10]) {
                        continue;
                    }
                    
                    visited[nextX + 10][nextY + 10] = true;
                    next.offer(new int [] {nextX, nextY});
                }
            }
            steps++;
        }
        
        return steps;
    }
}