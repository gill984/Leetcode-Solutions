class Solution {
    public int findKthPositive(int[] arr, int k) {
        int nextValue = 1;
        int missingCount = 0;
        
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val == nextValue) {
                nextValue++;
                continue;
            }
            
            // All values between next value and this val need to be skipped
            for (; nextValue < val && missingCount < k; nextValue++) {
                missingCount++;
                if (missingCount == k)
                    return nextValue;
            }
            nextValue++;
        }
        
        return nextValue + (k - missingCount - 1);
    }
}