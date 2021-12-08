class Solution {
    double MARGIN = 1E-9;
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        // All optimal rotations have at least 1 point on the edge of your sight
        // Iterate through having all possible points on the edge of sight
        // Need to be able to calculate the angle from a point to the origin
        // Sort points based on angle to the origin
        // pick an initial point
        // Create a deque with this point on the fron
        // add all points within angle to the back, once a point is reached outside angle,
        // pop front of deque until the next point can be added
        // How to calculate angle to a point?
        // atan2(dy, dx)
        
        // Calc angle from this element to all other points
        int dupes = 0;
        int max = 0;
        
        List<Double> angles = new ArrayList<>();
        for (List<Integer> p : points)
        {
            double dy = p.get(1) - location.get(1);
            double dx = p.get(0) - location.get(0);
            if (dy == 0 && dx == 0)
            {
                dupes++;
                continue;  // same point always counts
            }
            angles.add(Math.atan2(dy, dx) * (180.0 / Math.PI));
        }
        
        Collections.sort(angles);
        
        // set initial sliding window
        List<Double> temp = new ArrayList<>(angles);
        for (double d : angles)
            temp.add(d + 360.0);
        
        int lo = 0;
        int hi = 0;
        
        while (hi < temp.size() && lo < temp.size())
        {
            if (Math.abs(temp.get(hi) - temp.get(lo)) <= angle + MARGIN)
            {
                hi++;
            }
            else
            {
                lo++;
            }
            
            max = Math.max(max, hi - lo);
        }
        
        return max + dupes;
    }
}