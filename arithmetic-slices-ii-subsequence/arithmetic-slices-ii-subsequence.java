class Solution {
    final int STEP = 0;
    final int COUNT = 1;
    
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Integer> p = new HashMap<Integer, Integer>();      // previous element value -> count of that value
        Map<Integer, Integer> f = new HashMap<Integer, Integer>();      // future element value -> count of that value
        Map<Integer, Seq> sequences = new HashMap<Integer, Seq>();      // Target element to continue sequence -> Seq Object
        
        for (int i = 0; i < nums.length; i++)
            f.put(nums[i], f.getOrDefault(nums[i], 0) + 1);
        
        int res = 0;
        for (int num : nums)
        {
            // num is no longer a possible future sequence end, we are looking at it now
            f.put(num, f.get(num) - 1);
            if (f.get(num) == 0)
                f.remove(num);
            
            
            // Handle all possible length 3+ sequences with num at the end of them
            if (sequences.containsKey(num))
            {
                Seq s = sequences.get(num);
                res += s.count;
                for (int step : s.stepCounts.keySet())
                {
                    if (overflow(step, num, true))
                        continue;
                        
                    int count = s.stepCounts.get(step);
                    
                    // Add new sequences if we have this value in the future somewhere
                    if (f.containsKey(step + num))
                    {
                        Seq next = sequences.getOrDefault(step + num, new Seq());
                        next.count += count;
                        next.stepCounts.put(step, next.stepCounts.getOrDefault(step, 0) + count);
                        sequences.putIfAbsent(step + num, next);
                    }
                }
            }
            
            // Find all possible length 2 sequences with num as the second element
            for (int first : p.keySet())
            {
                int count = p.get(first);
                if (overflow(num, first, false))
                    continue;
                
                int step = num - first;
                if (overflow(num, step, true))
                    continue;
                
                int target = num + step;
                if (f.containsKey(target))
                {
                    Seq next = sequences.getOrDefault(target, new Seq());
                    next.count += count;
                    next.stepCounts.put(step, next.stepCounts.getOrDefault(step, 0) + count);
                    sequences.putIfAbsent(target, next);
                }
            }
            
            p.put(num, p.getOrDefault(num, 0) + 1);
        }
        
        return res;
    }
    
    public boolean overflow(int a, int b, boolean add)
    {
        long sum = 0;
        if (add)
            sum = (long) a + (long) b;
        else
            sum = (long) a - (long) b;
        
        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE)
            return true;
        else
            return false;
    }
    
    class Seq
    {
        int count;
        Map<Integer, Integer> stepCounts;
        
        public Seq ()
        {
            count = 0;
            stepCounts = new HashMap<Integer, Integer>();
        }
    }
}