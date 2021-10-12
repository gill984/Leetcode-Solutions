class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int lo = 0;
        int hi = n - 1;
        int res = 0;
        
        while (lo < hi)
        {
            res = Math.max(res, (hi - lo) * Math.min(height[hi], height[lo]));
            
            // Move the edge with the smaller height inwards until we get to a larger height
            if (height[lo] < height[hi])
                lo++;
            else
                hi--;
        }
        
        return res;
    }
}