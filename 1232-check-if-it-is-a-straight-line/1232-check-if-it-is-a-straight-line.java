class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        int ySlope = coordinates[1][1] - coordinates[0][1];
        int xSlope = coordinates[1][0] - coordinates[0][0];
        
        for (int i = 2; i < coordinates.length; i++) {
            int nextYSlope = coordinates[i][1] - coordinates[i - 1][1];
            int nextXSlope = coordinates[i][0] - coordinates[i - 1][0];
            
            
            
            // Cross multiply and check equality
            if (xSlope * nextYSlope != ySlope * nextXSlope) {
                return false;
            }
        }
        
        return true;
    }
}