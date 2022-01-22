class Solution {
    public boolean winnerSquareGame(int n) {
        // Goal of player is to force the number of stones to 0.
        // Each player does not want to put the number of stones at
        // a square number, or the other player will reduce the stones
        // to 0 on the next turn.
        // Likewise, can only get to 0 by taking away a square number of stones
        // 
        
        // Consider 0 as a loss position for the player whose turn it is
        // then 0 + s where s is a square number is a winning position.
        // Can we branch out from 0 and solve for all values <= 10^5?
        int MAX_BOUND = 100000;
        List<Integer> squares = new ArrayList<Integer>();
        Set<Integer> wins = new HashSet<Integer>();
        
        
        for (int i = 1; i <= Math.sqrt(n); i++)
            squares.add(i * i);
        
        for (int i = 0; i <= n; i++)
        {
            if (!wins.contains(i))
            {
                for (int s : squares)
                {
                    wins.add(s + i);
                }
            }
        }
        
        // System.out.println(squares);
        
        return wins.contains(n);
    }
}