class Solution {
    final int START = 0;
    final int END = 1;
    final long MOD = 1000000007;
    
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        Arrays.sort(requests, (a, b) -> a[0] - b[0]);
        Arrays.sort(nums);
        
        int [] counts = new int[n];
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (int r = 0; r < requests.length; r++)
        {
            int index = requests[r][START];
            ends.offer(requests[r][END]);
            
            while (index < n && !ends.isEmpty())
            {
                while (!ends.isEmpty() && index > ends.peek())
                {
                    ends.poll();
                }
                
                while (r + 1 < requests.length && index >= requests[r + 1][START])
                {
                    ends.offer(requests[r + 1][END]);
                    r += 1;
                }
                
                counts[index] = ends.size();
                index++;
            }
        }
        
        Arrays.sort(counts);
        // System.out.println(Arrays.toString(counts));
        // System.out.println(Arrays.toString(nums));
        
        long res = 0;
        for (int i = n - 1; i >= 0; i--)
            res = (res + ( (long) nums[i] * (long) counts[i])) % MOD;
        
        return (int) res;
    }
}