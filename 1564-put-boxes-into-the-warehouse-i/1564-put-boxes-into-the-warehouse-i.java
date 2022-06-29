class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        if (warehouse == null || warehouse.length == 0)
            return 0;
        
        // Sort the boxes, want to put smallest box in first
        // Stack of the smallest heights so far
        int w = warehouse.length;
        int b = boxes.length;
        Arrays.sort(boxes);
        ArrayDeque<Integer> minHeightIndices = new ArrayDeque<>();
        
        
        // Create the stack
        minHeightIndices.addLast(0);
        for (int i = 0; i < w; i++)
            if (warehouse[minHeightIndices.peekLast()] > warehouse[i])
                minHeightIndices.addLast(i);
        
        int box = 0;
        for (int i = w - 1; i >= 0 && box < b; i--) {
            if (i < minHeightIndices.peekLast())
                minHeightIndices.removeLast();
            
            if (boxes[box] <= warehouse[minHeightIndices.peekLast()])
                box++;
        }
        
        return box;
    }
}