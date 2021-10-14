class Solution {
    public int minDifference(int[] nums) {
        // max heap and min heap
        if (nums.length <= 4)
            return 0;
        
        PriorityQueue<int[]> threeSmallest = new PriorityQueue<>(3, (a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> threeLargest = new PriorityQueue<>(3, (a, b) -> a[1] - b[1]);
        int k = 4;
        
        for (int i = 0; i < nums.length; i++)
        {
            int [] pair = new int [] {i, nums[i]};
            
            if (threeSmallest.size() < k)
                threeSmallest.offer(pair);
            else if (threeSmallest.peek()[1] > pair[1])
            {
                threeSmallest.poll();
                threeSmallest.offer(pair);
            }
            
            if (threeLargest.size() < k)
                threeLargest.offer(pair);
            else if (threeLargest.peek()[1] < pair[1])
            {
                threeLargest.poll();
                threeLargest.offer(pair);
            }
        }
        
        // Handle smallest changing first
        int [] fourthSmallest = threeSmallest.poll();
        int [] thirdSmallest = threeSmallest.poll();
        int [] secondSmallest = threeSmallest.poll();
        int [] smallest = threeSmallest.poll();
        
        int [] fourthLargest = threeLargest.poll();
        int [] thirdLargest = threeLargest.poll();
        int [] secondLargest = threeLargest.poll();
        int [] largest = threeLargest.poll();
        
        int res1 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i == thirdSmallest[0] || i == secondSmallest[0] || i == smallest[0])
            {
                continue;
            }
            else
            {
                res1 = Math.max(res1, Math.abs(nums[i] - largest[1]));
                res1 = Math.max(res1, Math.abs(nums[i] - fourthSmallest[1]));
            }
        }
        
        int res2 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i == thirdLargest[0] || i == secondLargest[0] || i == largest[0])
            {
                continue;
            }
            else
            {
                res2 = Math.max(res2, Math.abs(nums[i] - smallest[1]));
                res2 = Math.max(res2, Math.abs(nums[i] - fourthLargest[1]));
            }
        }
        
        int res3 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i == smallest[0] || i == secondLargest[0] || i == largest[0])
            {
                continue;
            }
            else
            {
                res3 = Math.max(res3, Math.abs(nums[i] - secondSmallest[1]));
                res3 = Math.max(res3, Math.abs(nums[i] - thirdLargest[1]));
            }
        }
        
        int res4 = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i == smallest[0] || i == secondSmallest[0] || i == largest[0])
            {
                continue;
            }
            else
            {
                res4 = Math.max(res4, Math.abs(nums[i] - thirdSmallest[1]));
                res4 = Math.max(res4, Math.abs(nums[i] - secondLargest[1]));
            }
        }
        
        return Math.min(Math.min(res1, res2), Math.min(res3, res4));
    }
}