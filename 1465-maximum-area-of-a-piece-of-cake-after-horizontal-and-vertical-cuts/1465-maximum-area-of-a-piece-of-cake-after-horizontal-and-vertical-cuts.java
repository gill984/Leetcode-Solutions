class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Sort horizontal and vertical cuts
        // Process each chunk on each vertical line
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int prev = 0;
        
        long maxWidth = 0;
        long maxHeight = 0;
        
        for (int i : horizontalCuts) {
            maxHeight = Math.max(maxHeight, i - prev);
            prev = i;
        }
        maxHeight = Math.max(maxHeight, h - prev);
        
        prev = 0;
        for (int i : verticalCuts) {
            maxWidth = Math.max(maxWidth, i - prev);
            prev = i;
        }
        maxWidth = Math.max(maxWidth, w - prev);
        
        return Math.floorMod(maxHeight * maxWidth, 1000000007);
    }
}