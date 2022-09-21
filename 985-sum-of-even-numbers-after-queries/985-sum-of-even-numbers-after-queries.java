class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int [] res = new int [queries.length];
        int sum = 0;
        for (int i : nums)
            if (i % 2 == 0)
                sum += i;
        
        for (int i = 0; i < queries.length; i++) {
            int qdx = queries[i][1];
            int qval = queries[i][0];
            int currVal = nums[qdx];
            int newVal = currVal + qval;
            nums[qdx] = newVal;
            
            boolean newEven = (newVal % 2 == 0);
            boolean currEven = (currVal % 2 == 0);
            
            if (currEven && newEven) {
                sum += (newVal - currVal);
            } else if (currEven && !newEven) {
                sum -= currVal;
            } else if (!currEven && newEven) {
                sum += newVal;
            }
            res[i] = sum;
        }
        
        return res;
    }
}