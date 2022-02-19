class Solution {
    public int minimumDeviation(int[] nums) {
        // First convert all numbers to maximum values
        // Note that all minimum values will be even
        PriorityQueue<Integer> evens = new PriorityQueue<>((a, b) -> b - a);
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] % 2 == 0)
            {
                evens.offer(nums[i]);
                min = Math.min(min, nums[i]);
            }
            else
            {
                evens.offer(nums[i] * 2);
                min = Math.min(min, nums[i] * 2);
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        while (!evens.isEmpty())
        {
            // System.out.print(evens);
            int val = evens.poll();
            res = Math.min(res, val - min);
            // System.out.println(", min deviation: " + res);
            
            if (val % 2 == 1)
                break;
            else
            {
                evens.offer(val / 2);
                min = Math.min(min, val / 2);
            }
        }
        
        return res;
    }
}