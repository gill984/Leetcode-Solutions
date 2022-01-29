class Solution {
    public int largestRectangleArea(int[] heights) {
        int [] left = new int [heights.length];
        int [] right = new int [heights.length];
        
        if(heights.length == 0)
            return 0;
        
        left[0] = -1;
        right[right.length - 1] = right.length;
        
        // Populate left. left[i] holds the index which is closest to i to the left for which
        // heights[i] > heights[left[i]]
        for(int i = 1; i < heights.length; i++)
        {
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i])
                p = left[p];
            left[i] = p;
        }
        
        for(int i = heights.length - 2; i >= 0; i--)
        {
            int p = i + 1;
            while(p < heights.length && heights[p] >= heights[i])
                p = right[p];
            right[i] = p;
        }
        
        // Left and right populated
        int max = 0;
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        for(int i = 0; i < heights.length; i++)
        {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        
        return max;
    }
}