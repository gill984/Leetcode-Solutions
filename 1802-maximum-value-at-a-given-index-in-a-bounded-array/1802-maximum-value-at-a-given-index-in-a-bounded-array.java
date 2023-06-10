class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long hi = Integer.MAX_VALUE;
        long lo = 0;
        long res = 0;
        
        while (hi >= lo) {
            long mid = (hi + lo) / 2;
            if (isPossibleMax(mid, n, index, maxSum)) {
                lo = mid + 1;
                res = Math.max(res, mid);
            } else {
                hi = mid - 1;
            }
        }
        
        return (int) res;
    }
    
    public boolean isPossibleMax(long guess, int n, int index, int maxSum) {
        int leftLength = index + 1;
        int rightLength = n - index;
        long sum = calcTriangle(guess) + calcTriangle(guess) - guess;
        if (leftLength < guess) {
            sum -= calcTriangle(guess - leftLength);
        } else if (leftLength > guess) {
            sum += leftLength - guess;
        }
        
        if (rightLength < guess) {
            sum -= calcTriangle(guess - rightLength);
        } else if (rightLength > guess) {
            sum += rightLength - guess;
        }
        
        return sum <= maxSum;
    }
    
    public long calcTriangle (long x) {        
        return x * (x + 1) / 2;
    }
}