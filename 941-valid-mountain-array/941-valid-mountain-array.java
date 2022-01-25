class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        
        if (n < 3)
            return false;
        
        int idx = 1;
        for (; idx < n && arr[idx] > arr[idx - 1]; idx++)
        {
            
        }
        
        if (idx == n || idx == 1)
            return false;
            
        for (; idx < n && arr[idx] < arr[idx - 1] ; idx++)
        {
            
        }
            
        return (idx == n);
    }
}