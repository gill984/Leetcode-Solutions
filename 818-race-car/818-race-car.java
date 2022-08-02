class Solution {
    int POS = 0;
    int SPEED = 1;
    int MOVES = 2;
    public int racecar(int target) {
        ArrayDeque<int[]> paths = new ArrayDeque<>();
        int [] start = new int [] {0, 1, 0};
        paths.offer(start);
        HashSet<String> visited = new HashSet<>();
        
        while (!paths.isEmpty()) {
            int [] p = paths.poll();
            int pos = p[POS];
            int speed = p[SPEED];
            int moves = p[MOVES];
            
            String key = pos + "," + speed;
            if (visited.contains(key)) {
                continue;
            } else {
                visited.add(key);
            }
            
            if (pos == target) {
                return moves;
            }
            
            // Try moving in same direction and reverse direction
            // Only reverse if we need to turn around, or we're going to jump past
            int delta = target - pos;
            int newDelta = target - (pos + speed);
            if (delta > 0 && speed < 0 || delta < 0 && speed > 0 
                || delta > 0 && newDelta < 0 || delta < 0 && newDelta > 0) {
                int [] reverse = new int [] {pos, speed > 0 ? -1 : 1, moves + 1};
                paths.offer(reverse);
            }
            
            int [] accel = new int [] {pos + speed, speed * 2, moves + 1};
            paths.offer(accel);
        }
        
        return -1;
    }
}