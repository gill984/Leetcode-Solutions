class Solution
{
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int lo = 0;
        int hi = arr.length;
        int mid = (lo + hi) / 2;
        
        while(lo < hi)
        {
            mid = (lo + hi) / 2;            
            if(arr[mid] == x) break;
            if(arr[mid] < x) lo = mid + 1;
            if(arr[mid] > x) hi = mid;
        }
        
        if(x > arr[mid]) mid++;
        
        // Insertion point found
        lo = mid - 1;
        hi = mid;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(k > 0)
        {
            if((hi >= arr.length || hi < 0) && lo >= 0 && lo < arr.length)
            {
                list.add(arr[lo]);
                lo--;
            }
            else if((lo >= arr.length || lo < 0) && hi >= 0 && hi < arr.length)
            {
                list.add(arr[hi]);
                hi++;
            }
            else if(Math.abs(x - arr[hi]) < Math.abs(x - arr[lo]))
            {
                list.add(arr[hi]);
                hi++;
            }
            else if(Math.abs(x - arr[lo]) <= Math.abs(x - arr[hi]))
            {
                list.add(arr[lo]);
                lo--;
            }
            
            // System.out.println(list);
            // System.out.println(k);
                             
            k--;
        }
        
        Collections.sort(list);
        return list;
    }
}