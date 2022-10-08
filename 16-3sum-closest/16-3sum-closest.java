class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Naive is n^3 algorithm, try each number with every other number
        
        // Smarter, Find all n^2 pairs, for each pair, search the original array for the best value
        // Sort the original array and use binary search then expand from the found value out to find the best value
        Arrays.sort(nums);
        
        // Initialize result to actual possible value
        int best = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                int sum = findBest(nums, i, j, target);
                if(Math.abs(target - sum) < Math.abs(target - best))
                {
                    best = sum;
                }
            }
        }
        
        return best;
    }
    
    public int findBest(int [] nums, int i, int j, int target)
    {
        int twoSum = nums[i] + nums[j];
        
        // The value we want to try to find in the array
        int search = target - twoSum;
        
        int searchIndex = Arrays.binarySearch(nums, search);
        
        if(searchIndex >= 0 && searchIndex != i && searchIndex != j)
        {
            return target;
        }
        else
        {
            // Value searched for is not in array, expand outwards from "insertion point"
            // to find next best value in the array
            int insertionPoint = searchIndex;
            if(searchIndex < 0)
                insertionPoint = -(searchIndex + 1);
            
            int lo = insertionPoint - 1;
            int hi = insertionPoint;
            
            // System.out.println("Insertion Point: " + insertionPoint);
            
            // Move hi and lo to their attempt spots
            while(lo >= 0 && (lo == i || lo == j)) lo--;
            while(hi < nums.length && (hi == i || hi == j)) hi++;
            
            int sum;
            if(lo < 0)
                return nums[hi] + twoSum;
            else if(hi >= nums.length)
                return nums[lo] + twoSum;
            else
            {
                int hiSum = nums[hi] + twoSum;
                int loSum = nums[lo] + twoSum;
                
                return Math.abs(hiSum - target) < Math.abs(loSum - target) ? hiSum : loSum;
            }               
        }
        
    }
}