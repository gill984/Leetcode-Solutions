class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }
    
    public void merge (int[] nums, int alo, int ahi, int blo, int bhi) {
        int i = alo;
        int j = blo;
        int idx = 0;
        
        int [] copy = new int [bhi - alo + 1];
        
        while (i <= ahi && j <= bhi)
            if (nums[i] < nums[j])
                copy[idx++] = nums[i++];
            else
                copy[idx++] = nums[j++];
        
        while (i <= ahi)
            copy[idx++] = nums[i++];
        
        while (j <= bhi)
            copy[idx++] = nums[j++];
        
        for (int k = 0; k < copy.length; k++)
            nums[alo + k] = copy[k];
    }
    
    public void mergeSort(int [] nums, int lo, int hi) {
        if (hi == lo)
            return;
        
        int mid = (lo + hi) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, mid + 1, hi);
    }
}