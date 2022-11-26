class Solution {
    int START = 0;
    int END = 1;
    int PROFIT = 2;
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // dp.get(i) = max profit at end time i
        TreeMap<Integer, Integer> dpTimeToProfit = new TreeMap<Integer, Integer>();
        
        // Base case, storing this explicitly allows us to remove some null checks and simplifies the code
        dpTimeToProfit.put(0, 0);
        
        // Tracking max manually saves some O(lg(n)) calls
        int max = 0;
        
        // Sort input by endTime to make it usable for the algorithm
        int n = startTime.length;
        int [][] input = new int [n][3];
        for (int i = 0; i < n; i++)
        {
            input[i][START] = startTime[i];
            input[i][END] = endTime[i];
            input[i][PROFIT] = profit[i];
        }
        Arrays.sort(input, (a, b) -> Integer.compare(a[END], b[END]));
        
        // The max profit after working this job is the max we could have had before this
        // job's start time plus this job's profit. If the max we can have from working
        // this job is better than our max so far, add it to the map. Since we are going
        // in order of increasing end times, only store a value if it's better than the current max.
        for (int i = 0; i < n; i++)
        {
            int [] job = input[i];
            int jobMaxProfit = dpTimeToProfit.floorEntry(job[START]).getValue() + job[PROFIT];
            if (max < jobMaxProfit) {
                dpTimeToProfit.put(job[END], jobMaxProfit);
                max = jobMaxProfit;
            }
        }
        
        return max;
    }
}