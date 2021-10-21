class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int [][] p = new int [][] {p1, p2, p3, p4};
        Arrays.sort(p, (a, b) -> Integer.compare(a[0], b[0]) == 0 ? 
                    Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        return dist2(p[0], p[1]) != 0 &&
            dist2(p[0], p[3]) == dist2(p[1], p[2]) &&
            dist2(p[0], p[1]) == dist2(p[2], p[3]) &&
            dist2(p[0], p[2]) == dist2(p[1], p[3]) &&
            dist2(p[0], p[1]) == dist2(p[1], p[3]);
        
    }
    
    public double dist2(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
}