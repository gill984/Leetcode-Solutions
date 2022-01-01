class Solution
{   
    public int maxCoins(int[] nums)
    {
        // Remove all 0 values and pad with 1s on the side
        Problem p = new Problem(nums);
        return p.solve();
    }
    
    
}

class Problem
{
    // Array which has had 0s removed and 1s padded on the left and right side
    int [] arr;
    
    // Number of elements to consider in arr, there will be 0s past index size - 1
    int size;
    
    // dp[i][j] = max coins received from bursting balloons between i and j (exclusive)
    // this means the solution to the problem will be at dp[0][size - 1] when we're done
    int [][] dp;
    
    // Take in the input and format it into the starting position we intend to solve the problem from
    // Remove 0s from array, count number of non-zeros, initialize dp array to a 2-d array of this count
    public Problem(int [] nums)
    {
        // Some grunt work to get things in the right format for solving
        int [] a = new int[nums.length + 2];
        int n = 1;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                a[n] = nums[i];
                n++;
            }
        }
        a[n] = 1;
        n++;
        a[0] = 1;
        
        // Initialize object fields
        this.size = n;
        this.arr = a;
        this.dp = new int[size][size];
    }
    
    public int solve()
    {
        // For each possible distance, up to size
        // d is the distance between left and right
        for(int d = 2; d < size; d++)
        {
            // For each possible value of left
            // Here we want to keep right < size as the upper bound
            for(int left = 0, right = left + d; right < size; left++, right++)
            {
                for(int i = left + 1; i < right; i++)
                {
                    dp[left][right] = Math.max(dp[left][right],  // Previous max
                        arr[i] * arr[left] * arr[right]          // Bursting this ballon last, plus
                        + dp[left][i] + dp[i][right]);           // the max of the left side and right side (precalculated in dp)
                }
            }
        }
        
        return dp[0][size - 1];
    }
}