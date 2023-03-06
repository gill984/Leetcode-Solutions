class Solution {
    public int findKthPositive(int[] arr, int k) {
        int nextValue = 1;
        int missingCount = 0;
        
        for (int val : arr) {
            // All values between next value and this val need to be skipped
            for (; nextValue < val && missingCount < k; nextValue++)
                missingCount++;
            
            if (missingCount == k)
                    return nextValue - 1;
            
            nextValue++;
        }
        
        return nextValue + (k - missingCount - 1);
    }
}