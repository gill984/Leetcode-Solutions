class Solution {
    public boolean winnerSquareGame(int n) {
        List<Integer> squares = new ArrayList<Integer>();
        Set<Integer> wins = new HashSet<Integer>();
        
        for (int i = 1; i <= Math.sqrt(n); i++)
            squares.add(i * i);
        
        for (int i = 0; i <= n; i++)
            if (!wins.contains(i))
                for (int s : squares)
                    wins.add(s + i);
        
        return wins.contains(n);
    }
}