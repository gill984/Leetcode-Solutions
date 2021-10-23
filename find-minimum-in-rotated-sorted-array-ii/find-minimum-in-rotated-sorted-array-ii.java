class Solution {
    public int findMin(int[] arr) {
        // Binary search for the pivot point
        // pivot point is the spot where arr[(i + 1) & n] < arr[i % n]
        // Let's say that arr[lo] < arr[hi], the pivot has to be outside the range [lo + 1, hi]
        int n = arr.length;
        int lo = 0;
        int hi = n - 1;
        int min = arr[0];
        
        while (lo <= hi)
        {
            int mid = (hi - lo) / 2 + lo;
            min = Math.min(min, arr[mid]);
            
            if (arr[mid] > arr[hi])
            {
                lo = mid + 1;
            }
            else if (arr[mid] < arr[lo])
            {
                lo = lo + 1;
                hi = mid;
            }
            else if (arr[mid] > arr[lo] && arr[mid] <= arr[hi])
            {
                return arr[lo];
            }
            else if (arr[mid] >= arr[lo] && arr[mid] < arr[hi])
            {
                return arr[lo];
            }
            else if (arr[mid] == arr[lo] && arr[mid] == arr[hi])
            {
                lo += 1;
                hi -= 1;
            }
        }
        
        return min;
    }
}