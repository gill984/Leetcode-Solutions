/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);
        
        int result = Integer.MAX_VALUE;
        for(int i = 0, j = cols - 1; i < rows && j >= 0;)
        {
            if(binaryMatrix.get(i, j) == 1)
            {
                result = Math.min(j, result);
                j -= 1;
            }
            else
                i += 1;
        }
        
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}