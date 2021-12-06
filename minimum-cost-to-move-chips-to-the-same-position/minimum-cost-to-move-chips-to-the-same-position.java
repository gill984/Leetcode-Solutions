class Solution {
    public int minCostToMoveChips(int[] position) {
        // Odds at even positions can go to other even positions with cost 0, odd cost 1
        // vice versa for chips on even spaces
        // Count chips on odd and even spaces, answer is the minimum of these 2 counts
        int even = 0;
        int odd = 0;
        for (int i : position)
        {
            if (i % 2 == 0)
                even++;
            else
                odd++;
        }
        
        return Math.min(even, odd);
    }
}