class Solution {
    int n;
    public boolean PredictTheWinner(int[] nums) {
        n = nums.length;
        return canWin(0, 0, 0, 0, true, nums);
    }
    
    public boolean canWin(int leftTaken, int rightTaken, int p1Score, int p2Score, boolean myTurn, int [] nums)
    {
        if (leftTaken + rightTaken == n) {
            // System.out.println(p1Score + " " + p2Score);
            return p1Score >= p2Score;
        }
        
        // Build left and right subtrees then call canWin on them
        int leftPick = nums[leftTaken];
        int rightPick = nums[n - 1 - rightTaken];
        
        // If it's our turn, we win if either path leads to a win for us
        // if it's not our turn, we only win if both paths lead to a win for us
        if (myTurn)
        {
            return canWin(leftTaken + 1, rightTaken, p1Score + leftPick, p2Score, !myTurn, nums) ||
                canWin(leftTaken, rightTaken + 1, p1Score + rightPick, p2Score, !myTurn, nums);
        }
        else
        {
            return canWin(leftTaken + 1, rightTaken, p1Score, p2Score + leftPick, !myTurn, nums) &&
                canWin(leftTaken, rightTaken + 1, p1Score, p2Score + rightPick, !myTurn, nums);
        }
    }
}

