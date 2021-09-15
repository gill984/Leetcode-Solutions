class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int [] dp = new int[n];
        
        int res = 1;
        for (int lo = 0; lo + 1 < n;)
        {
            int hi = lo + 1;
            if (arr[lo] == arr[hi])
            {
                lo++;
                continue;
            }
            
            // Set hi to last turbulent element of subarray starting at lo
            // hi goes 1 past this element in the loop, need to subtract 1 after
            boolean up = arr[hi] > arr[lo];
            while (hi < n)
            {
                if (up && arr[hi] > arr[hi - 1])
                    hi++;
                else if (!up && arr[hi] < arr[hi - 1])
                    hi++;
                else
                    break;
                
                up = !up;
            }
            
            hi--;
            res = Math.max(res, hi - lo + 1);
            lo = hi;
        }
        
        return res;
    }
}